package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.exception.ResourceNotFoundException;
import pe.com.megacentimetros.persona.entity.SucursalEntity;
import pe.com.megacentimetros.persona.repository.SucursalRepository;
import pe.com.megacentimetros.persona.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {

	private SucursalRepository repositorio;

	public SucursalServiceImpl(SucursalRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<SucursalEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<SucursalEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public SucursalEntity findById(Long id) {
		SucursalEntity sucursal = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sucursal con id " + id + " no existe"));
		return sucursal;
	}
	@Override
	public SucursalEntity add(SucursalEntity obj) {
		obj.setEstado(true);
		if (obj.getSituacion() == null) {
			obj.setSituacion("OPERATIVA");
		}
		return repositorio.save(obj);
	}
	@Override
	public SucursalEntity update(SucursalEntity obj, Long id) {
		SucursalEntity objsuc = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sucursal con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objsuc, "codigo");
		return repositorio.save(objsuc);
	}
	@Override
	public SucursalEntity delete(Long id) {
		SucursalEntity objsuc = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sucursal con id " + id + " no existe"));
		objsuc.setEstado(false);
		return repositorio.save(objsuc);
	}
	@Override
	public SucursalEntity enable(Long id) {
		SucursalEntity objsuc = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Sucursal con id " + id + " no existe"));
		objsuc.setEstado(true);
		return repositorio.save(objsuc);
	}
}
