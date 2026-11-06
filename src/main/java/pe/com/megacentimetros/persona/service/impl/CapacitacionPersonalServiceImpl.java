package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.exception.ResourceNotFoundException;
import pe.com.megacentimetros.persona.entity.CapacitacionPersonalEntity;
import pe.com.megacentimetros.persona.repository.CapacitacionPersonalRepository;
import pe.com.megacentimetros.persona.service.CapacitacionPersonalService;

@Service
public class CapacitacionPersonalServiceImpl implements CapacitacionPersonalService {

	private CapacitacionPersonalRepository repositorio;

	public CapacitacionPersonalServiceImpl(CapacitacionPersonalRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<CapacitacionPersonalEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<CapacitacionPersonalEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public CapacitacionPersonalEntity findById(Long id) {
		CapacitacionPersonalEntity capacitacionPersonal = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CapacitacionPersonal con id " + id + " no existe"));
		return capacitacionPersonal;
	}
	@Override
	public CapacitacionPersonalEntity add(CapacitacionPersonalEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public CapacitacionPersonalEntity update(CapacitacionPersonalEntity obj, Long id) {
		CapacitacionPersonalEntity objcap = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CapacitacionPersonal con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objcap, "codigo");
		return repositorio.save(objcap);
	}
	@Override
	public CapacitacionPersonalEntity delete(Long id) {
		CapacitacionPersonalEntity objcap = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CapacitacionPersonal con id " + id + " no existe"));
		objcap.setEstado(false);
		return repositorio.save(objcap);
	}
	@Override
	public CapacitacionPersonalEntity enable(Long id) {
		CapacitacionPersonalEntity objcap = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("CapacitacionPersonal con id " + id + " no existe"));
		objcap.setEstado(true);
		return repositorio.save(objcap);
	}
}
