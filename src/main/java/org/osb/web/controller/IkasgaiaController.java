package org.osb.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;
import org.osb.web.domain.artxiboa.model.Artxiboa;
import org.osb.web.domain.artxiboa.repository.ArtxiboaRepository;
import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.gaia.model.Gaia;
import org.osb.web.domain.gaia.service.GaiaService;
import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;
import org.osb.web.domain.ikasgaia.service.IkasgaiaService;
import org.osb.web.domain.ikaslea.service.IkasleaService;

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
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller
public class IkasgaiaController {

	@Autowired
	private IkasleaService ikasleaService;

	@Autowired
	private IkasgaiaService ikasgaiaService;

	@Autowired
	private ArtxiboaRepository artxiboaRepository;

	@Autowired
	private GaiaService gaiaService;

	// visualizar todas en base al user
	@GetMapping("/ikasgaiak")
	public String home(Model model, Principal principal) {
		List<IkasgaiaDto> ikasgaiak = ikasleaService.findIkasgaiakByUser(principal.getName());
		model.addAttribute("ikasgaiak", ikasgaiak);
		return "ikasgaiak";
	}

	// visualizar solo un ikasgai
	@GetMapping("/ikasgaiak/{ikasgaiid}")
	public String showGaiak(Model model, @PathVariable("ikasgaiid") Long ikasgaiID) {
		// aqui pillamos todos los gaiak del la ikasgaia que queremos
		List<GaiaDto> ikasgaiBatenGaiakDto = ikasgaiaService.findGaiakDtoByIkasgaiaID(ikasgaiID);
		model.addAttribute("gaiak", ikasgaiBatenGaiakDto);

		// aqui pillamos los archivos del primer tema para que se carguen
		// a la siguiente funcion le paso la lista de gaiak y pillare solo la primera
		List<Gaia> ikasgaiBatenGaiak = ikasgaiaService.findGaiakByIkasgaiaID(ikasgaiID);
		List<ArtxiboaDto> lehenengoGaiarenArtxiboak = gaiaService.findLehenengoGaiarenArtxiboak(ikasgaiBatenGaiak);
		model.addAttribute("artxiboak", lehenengoGaiarenArtxiboak);

		model.addAttribute("ikasgaia", ikasgaiaService.findIkasgaiaDtoByID(ikasgaiID));

		return "gaiak";
	}

	@GetMapping("/ikasgaiak/{ikasgaiid}/gaiak/{id}")
	public String showArtxiboak(Model model, @PathVariable("id") Long id, @PathVariable("ikasgaiid") Long ikasgaiaID) {

		System.out.println("gaiak controller");
		List<ArtxiboaDto> gaiBatenArtxiboak = gaiaService.findArtxiboakByGaiaID(id);
		model.addAttribute("artxiboak", gaiBatenArtxiboak);

		List<GaiaDto> ikasgaiBatenGaiak = ikasgaiaService.findGaiakDtoByIkasgaiaID(ikasgaiaID);
		model.addAttribute("gaiak", ikasgaiBatenGaiak);

		model.addAttribute("ikasgaia", ikasgaiaService.findIkasgaiaDtoByID(ikasgaiaID));

		return "gaiak";
	}

	@PostMapping("/ikasgaiak/{ikasgaiid}/gaiak/gaiaSortu")
	public RedirectView gaiaSortuGet(@Valid @ModelAttribute("gaia") GaiaDto gaia,
			@PathVariable("ikasgaiid") Long ikasgaiaID, @RequestParam("archivos") List<MultipartFile> files)
			throws IOException {
		List<ArtxiboaDto> listArtxiboaDtos = new ArrayList<>();
		gaia.setIkasgaiIzena(ikasgaiaService.findIkasgaiaDtoByID(ikasgaiaID).getIzena());

		for (MultipartFile file : files) {
			ArtxiboaDto tmp = new ArtxiboaDto();
			tmp.setDokumentua(file.getBytes());
			tmp.setIzena(file.getOriginalFilename());
			listArtxiboaDtos.add(tmp);
		}
		gaia.setArtxiboDtoLista(listArtxiboaDtos);
		gaiaService.saveGaia(gaia);

		return new RedirectView("/ikasgaiak/" + ikasgaiaID);
	}

	@GetMapping("/ikasgaiak/{ikasgaiid}/gaiak/gaiaSortu")
	public String gaiaSortuPost(Model model, @PathVariable("ikasgaiid") Long ikasgaiaID) {
		model.addAttribute("ikasgaia", ikasgaiaService.findIkasgaiaDtoByID(ikasgaiaID));
		return "gaiaSortu";
	}

	@GetMapping("/ikasgaiak/{ikasgaiid}/gaiak/{id}/descargatu")
	public ResponseEntity<byte[]> apunteakDescarga(@PathVariable("id") Long id) {
		Artxiboa apunteak2 = artxiboaRepository.findById(id).orElse(new Artxiboa());
		if (apunteak2 != null) {
			byte[] contenidoArchivo = apunteak2.getDokumentua();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("attachment", apunteak2.getIzena());

			return new ResponseEntity<>(contenidoArchivo, headers, HttpStatus.OK);
		}
		return null;
	}

}