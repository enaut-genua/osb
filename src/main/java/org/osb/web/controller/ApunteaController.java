package org.osb.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.osb.web.domain.apuntea.dto.ApunteaDto;
import org.osb.web.domain.apuntea.service.ApunteaService;
import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;
import org.osb.web.domain.balorazioa.dto.BalorazioaDto;
import org.osb.web.domain.balorazioa.service.BalorazioaService;
import org.osb.web.domain.ikasgaia.service.IkasgaiaService;
import org.osb.web.domain.user.dto.UserDto;
import org.osb.web.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ApunteaController {

	@Autowired
	private IkasgaiaService ikasgaiaService;

	@Autowired
	private UserService userService;

	@Autowired
	private ApunteaService apunteaService;

	@Autowired
	private BalorazioaService balorazioaService;

	@GetMapping("/apunteak/{ikasgaiid}")
	public String apuntetegiaFiltratuta(@PathVariable("ikasgaiid") Long ikasgaiID, Model model) {
		model
				.addAttribute( // Apunteak bistaratzeko atributua
						"apunteak",
						ikasgaiaService
								.findIkasgaiaDtoByID(ikasgaiID)
								.map(ikasgaiaDto -> ikasgaiaDto.getApunteak())
								.orElse(new ArrayList<>()))
				.addAttribute(
						"ikasgaiid",
						ikasgaiaService
								.findIkasgaiaDtoByID(ikasgaiID)
								.orElseThrow())
				.addAttribute("balorazioa", new BalorazioaDto());
		return "apuntetegia";
	}

	@GetMapping("/apunteak")
	public String apuntetegia(Model model) {
		model.addAttribute("apunteak", apunteaService.findAllApunteaDto());
		return "apuntetegia";
	}

	@PostMapping("/apunteak/{apunteId}")
	public String apuntetegiaPost(@PathVariable("apunteId") Long apunteId, @RequestParam("bozka") int bozka,
			Principal principal) {
		UserDto userDto = userService
				.findUserDtoByEmail(principal.getName())
				.orElseThrow(() -> new IllegalStateException("Hona iristeko beti logeatua egon behar du."));
		ApunteaDto apunteaDto = apunteaService
				.findApunteaDtoById(apunteId)
				.orElseThrow(() -> new IllegalStateException("Hona iristeko beti baliozko apunte bat behar da."));
		BalorazioaDto balorazioa = new BalorazioaDto();
		balorazioa.setBalorazioa(bozka);
		balorazioa.setUserDto(userDto);
		balorazioa.setApunteaDto(apunteaDto);
		balorazioaService.saveBalorazioa(balorazioa);
		return "apuntetegia";
	}

	@GetMapping("/apunteak/sortu")
	public String apuntetegiaSortu(Model model) {
		return "apunteaSortu";
	}

	@PostMapping("/apunteak/gorde")
	public String apuntetegiaSortuPost(
			@ModelAttribute("apuntea") ApunteaDto apunteaDto,
			@RequestParam("artxiboak") List<MultipartFile> multipartFiles,
			Principal principal) throws IOException {
		apunteaDto.setArtxiboDtoLista(new ArrayList<>());
		apunteaDto.setEgileEmail(principal.getName());
		for (MultipartFile multiPartFile : multipartFiles) {
			ArtxiboaDto artxiboaDto = new ArtxiboaDto();
			artxiboaDto.setIzena(multiPartFile.getOriginalFilename());
			artxiboaDto.setDatuak(multiPartFile.getBytes());
			apunteaDto.getArtxiboDtoLista().add(artxiboaDto);
		}

		apunteaService.saveApuntea(apunteaDto);

		return "apuntetegia";
	}

	@GetMapping("/apunteak/{apunteId}/deskargatu")
	public ResponseEntity<byte[]> apuntetegiaDeskargatu(@PathVariable("apunteId") Long apunteId) {
		Optional<ApunteaDto> apunteaDtoOptional = apunteaService.findApunteaDtoById(apunteId);
		if (apunteaDtoOptional.isPresent()) {
			byte[] contenidoArchivo = apunteaDtoOptional.get().getArtxiboDtoLista().get(0).getDatuak();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("attachment", apunteaDtoOptional.get().getIzena());

			return new ResponseEntity<>(contenidoArchivo, headers, HttpStatus.OK);
		}
		return null;
	}
}
