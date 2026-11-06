package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.CapacitacionPersonalEntity;

public interface CapacitacionPersonalService {

	List<CapacitacionPersonalEntity> findAll();

	List<CapacitacionPersonalEntity> findAllCustom();

	CapacitacionPersonalEntity findById(Long id);

	CapacitacionPersonalEntity add(CapacitacionPersonalEntity obj);

	CapacitacionPersonalEntity update(CapacitacionPersonalEntity obj, Long id);

	CapacitacionPersonalEntity delete(Long id);

	CapacitacionPersonalEntity enable(Long id);
}
