package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.TransportistaEntity;

public interface TransportistaService {

	List<TransportistaEntity> findAll();

	List<TransportistaEntity> findAllCustom();

	TransportistaEntity findById(Long id);

	TransportistaEntity add(TransportistaEntity obj);

	TransportistaEntity update(TransportistaEntity obj, Long id);

	TransportistaEntity delete(Long id);

	TransportistaEntity enable(Long id);
}
