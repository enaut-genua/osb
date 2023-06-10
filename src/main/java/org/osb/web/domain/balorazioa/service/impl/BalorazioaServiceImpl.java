package org.osb.web.domain.balorazioa.service.impl;

import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.apuntea.service.ApunteaService;
import org.osb.web.domain.balorazioa.dto.BalorazioaDto;
import org.osb.web.domain.balorazioa.model.Balorazioa;
import org.osb.web.domain.balorazioa.repository.BalorazioaRepository;
import org.osb.web.domain.balorazioa.service.BalorazioaService;
import org.osb.web.domain.user.model.User;
import org.osb.web.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalorazioaServiceImpl implements BalorazioaService {

	@Autowired
	private BalorazioaRepository balorazioaRepository;

	@Autowired
	private ApunteaService apunteaService;

	@Autowired
	private UserService userService;

	@Override
	public void saveBalorazioa(BalorazioaDto balorazioaDto) {
		Apuntea apuntea = apunteaService
				.findApunteaById(balorazioaDto.getApunteaDto().getId())
				.orElseThrow(() -> new IllegalStateException("Apunte ID-a jakin beharra dago."));

		User user = userService
				.findUserByEmail(balorazioaDto.getUserDto().getEmail())
				.orElseThrow(() -> new IllegalStateException("User email jakina da."));

		if (balorazioaRepository.findByApunteaAndUser(apuntea, user).isEmpty()) {
			Balorazioa balorazioa = new Balorazioa();
			balorazioa.setApuntea(apuntea);
			balorazioa.setUser(user);
			balorazioa.setBalorazioa(balorazioaDto.getBalorazioa());
			balorazioaRepository.save(balorazioa);
		}
	}

}
