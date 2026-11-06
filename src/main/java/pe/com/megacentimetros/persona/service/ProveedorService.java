package pe.com.megacentimetros.persona.service;

import java.util.List;
import pe.com.megacentimetros.persona.entity.ProveedorEntity;

public interface ProveedorService {

	List<ProveedorEntity> findAll();

	List<ProveedorEntity> findAllCustom();

	ProveedorEntity findById(Long id);

	ProveedorEntity add(ProveedorEntity obj);

	ProveedorEntity update(ProveedorEntity obj, Long id);

	ProveedorEntity delete(Long id);

	ProveedorEntity enable(Long id);
}
