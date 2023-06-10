package org.osb.web.domain.balorazioa.repository;

import java.util.Optional;

import org.osb.web.domain.apuntea.model.Apuntea;
import org.osb.web.domain.balorazioa.model.Balorazioa;
import org.osb.web.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;

public interface BalorazioaRepository extends CrudRepository<Balorazioa, Long> {
	Optional<Balorazioa> findByApunteaAndUser(Apuntea apuntea, User user);
}
