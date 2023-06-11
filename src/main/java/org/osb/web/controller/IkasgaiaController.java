package org.osb.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.osb.web.domain.artxiboa.dto.ArtxiboaDto;
import org.osb.web.domain.artxiboa.model.Artxiboa;
import org.osb.web.domain.artxiboa.repository.ArtxiboaRepository;
import org.osb.web.domain.azterketa.dto.AzterketaDto;
import org.osb.web.domain.azterketa.service.AzterketaService;
import org.osb.web.domain.ebaluaketa.dto.EbaluaketaDto;
import org.osb.web.domain.gaia.dto.GaiaDto;
import org.osb.web.domain.gaia.service.GaiaService;
import org.osb.web.domain.ikasgaia.dto.IkasgaiaDto;
import org.osb.web.domain.ikasgaia.model.Ikasgaia;
import org.osb.web.domain.ikasgaia.repository.IkasgaiaRepository;
import org.osb.web.domain.ikasgaia.service.IkasgaiaService;
import org.osb.web.domain.user.model.User;
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
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class IkasgaiaController {

	@Autowired
	private UserService userService;

	@Autowired
	private IkasgaiaService ikasgaiaService;

	@Autowired
	private IkasgaiaRepository ikasgaiaRepository;

	@Autowired
	private ArtxiboaRepository artxiboaRepository;

	@Autowired
	private GaiaService gaiaService;

	@Autowired
	private AzterketaService azterketaService;

	// visualizar todas en base al user
	@GetMapping("/ikasgaiak")
	public String home(Model model, Principal principal) {
		model.addAttribute("ikasgaiak", userService.findIkasgaiakDtoByUser(principal.getName()));
		model.addAttribute("user", userService.findUserByEmail(principal.getName()).orElseThrow());
		return "ikasgaiak";
	}

	// visualizar solo un ikasgai
	@GetMapping("/ikasgaiak/{ikasgaiid}")
	public String showGaiak(Model model, @PathVariable("ikasgaiid") Long ikasgaiID, Principal principal) {
		// aqui pillamos todos los gaiak del la ikasgaia que queremos
		List<GaiaDto> ikasgaiBatenGaiakDto = ikasgaiaService.findGaiakDtoByIkasgaiaID(ikasgaiID);
		model.addAttribute("gaiak", ikasgaiBatenGaiakDto);
		model.addAttribute("ikasgaia", ikasgaiaService.findIkasgaiaDtoByID(ikasgaiID)
				.orElseThrow(() -> new IllegalStateException("Hemen ID-a zuzena izan beharko litzateke.")));
		model.addAttribute("user", userService.findUserByEmail(principal.getName()).orElseThrow());
		return "gaiak";
	}

	@PostMapping("/ikasgaiak/{ikasgaiid}/gaiak/sortu")
	public RedirectView gaiaSortuPost(@Valid @ModelAttribute("gaia") GaiaDto gaia,
			@PathVariable("ikasgaiid") Long ikasgaiaID, @RequestParam("archivos") List<MultipartFile> files)
			throws IOException {
		List<ArtxiboaDto> listArtxiboaDtos = new ArrayList<>();

		Optional<IkasgaiaDto> ikasgaiaDtoOptional = ikasgaiaService.findIkasgaiaDtoByID(ikasgaiaID);

		if (ikasgaiaDtoOptional.isPresent()) {
			gaia.setIkasgaiIzena(ikasgaiaDtoOptional.get().getIzena());
			for (MultipartFile file : files) {
				ArtxiboaDto tmp = new ArtxiboaDto();
				tmp.setDatuak(file.getBytes());
				tmp.setIzena(file.getOriginalFilename());
				listArtxiboaDtos.add(tmp);
			}
			gaia.setArtxiboDtoLista(listArtxiboaDtos);
			gaiaService.saveGaia(gaia);
		}

		return new RedirectView("/ikasgaiak/" + ikasgaiaID);
	}

	@GetMapping("/ikasgaiak/{ikasgaiid}/gaiak/sortu")
	public String gaiaSortuGet(Model model, @PathVariable("ikasgaiid") Long ikasgaiaID, Principal principal) {
		model.addAttribute("ikasgaia", ikasgaiaService.findIkasgaiaDtoByID(ikasgaiaID).orElseThrow());
		model.addAttribute("user", userService.findUserByEmail(principal.getName()).orElseThrow());
		return "gaiaSortu";
	}

	@GetMapping("/gaiak/{id}/deskargatu")
	public ResponseEntity<byte[]> apunteakDescarga(@PathVariable("id") Long id) {
		Artxiboa artxiboa = artxiboaRepository.findById(id).orElse(new Artxiboa());
		if (artxiboa != null) {
			byte[] contenidoArchivo = artxiboa.getDokumentua();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("attachment", artxiboa.getIzena());

			return new ResponseEntity<>(contenidoArchivo, headers, HttpStatus.OK);
		}
		return null;
	}

    @PostMapping("/ikasgaiak/{ikasgaiid}/notak/sortu")
	public String notaking(Model model, @PathVariable("ikasgaiid") Long ikasgaiID, @RequestParam("nota") double nota, @RequestParam("ikaslea") String ikaslea, 
            @RequestParam("komentarioa") String komentarioa, @RequestParam("izena") String izena, Principal principal, HttpServletRequest request) {

		AzterketaDto azterketaDto = new AzterketaDto(null, null, izena, null);
		EbaluaketaDto ebaluaketaDto = new EbaluaketaDto(nota, null, komentarioa);
		User user = userService.findUserByEmail(ikaslea).orElseThrow();
		ebaluaketaDto.setIkaslea(user.getIkaslea());

        Ikasgaia ikasgaia = ikasgaiaRepository.findByIzena(ikasgaiaRepository.findById(ikasgaiID).orElseThrow().getIzena()).orElseThrow();
		azterketaDto.setIkasgaia(ikasgaia);

        model
				.addAttribute("ikasgaia", ikasgaiaRepository.findById(ikasgaiID).orElseThrow())
				.addAttribute("user", userService.findUserByEmail(principal.getName()).orElseThrow());
		

		azterketaService.saveAzterketa(azterketaDto, ebaluaketaDto);

		return "ikasgaiak"; 
	}

	@GetMapping("/ikasgaiak/{ikasgaiid}/notak/sortu")
	public String sortu(Model model, @PathVariable("ikasgaiid") Long ikasgaiID, Principal principal) {

		IkasgaiaDto ikasgaia = ikasgaiaService.findIkasgaiaDtoByID(ikasgaiID).orElseThrow();

		model.addAttribute("ikasgaia", ikasgaia);
		model.addAttribute("ebaluaketa", new EbaluaketaDto());
		model.addAttribute("azterketa", new AzterketaDto());

        User user = userService.findUserByEmail(principal.getName()).orElseThrow();
        model.addAttribute("user", user);
		
		return "notaSortu";
	}

    @GetMapping("/ikasgaiak/notak/ikusi")
    public String notakIkusi(Model model, Principal principal) {
        User user = userService.findUserByEmail(principal.getName()).get();
        model.addAttribute("user", user);

        List<AzterketaDto> azterketaDto = azterketaService.findByIkalsea(user.getIkaslea());
        model.addAttribute("azterketak", azterketaDto);

        return "notak";
    }
}