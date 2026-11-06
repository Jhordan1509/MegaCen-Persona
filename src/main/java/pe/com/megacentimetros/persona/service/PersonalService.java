package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.PersonalEntity;

public interface PersonalService {

	List<PersonalEntity> findAll();

	List<PersonalEntity> findAllCustom();

	PersonalEntity findById(Long id);

	PersonalEntity add(PersonalEntity obj);

	PersonalEntity update(PersonalEntity obj, Long id);

	PersonalEntity delete(Long id);

	PersonalEntity enable(Long id);
}
