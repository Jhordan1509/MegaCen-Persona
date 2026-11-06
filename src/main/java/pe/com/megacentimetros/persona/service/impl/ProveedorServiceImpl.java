package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.exception.ResourceNotFoundException;
import pe.com.megacentimetros.persona.entity.ProveedorEntity;
import pe.com.megacentimetros.persona.repository.ProveedorRepository;
import pe.com.megacentimetros.persona.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	private ProveedorRepository repositorio;

	public ProveedorServiceImpl(ProveedorRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<ProveedorEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<ProveedorEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public ProveedorEntity findById(Long id) {
		ProveedorEntity proveedor = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proveedor con id " + id + " no existe"));
		return proveedor;
	}
	@Override
	public ProveedorEntity add(ProveedorEntity obj) {
		obj.setEstado(true);
		if (obj.getFechaRegistro() == null) {
			obj.setFechaRegistro(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public ProveedorEntity update(ProveedorEntity obj, Long id) {
		ProveedorEntity objpro = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proveedor con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objpro, "codigo", "fechaRegistro");
		return repositorio.save(objpro);
	}
	@Override
	public ProveedorEntity delete(Long id) {
		ProveedorEntity objpro = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proveedor con id " + id + " no existe"));
		objpro.setEstado(false);
		return repositorio.save(objpro);
	}
	@Override
	public ProveedorEntity enable(Long id) {
		ProveedorEntity objpro = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Proveedor con id " + id + " no existe"));
		objpro.setEstado(true);
		return repositorio.save(objpro);
	}
}
