package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.exception.ResourceNotFoundException;
import pe.com.megacentimetros.persona.entity.ControlAsistenciaEntity;
import pe.com.megacentimetros.persona.repository.ControlAsistenciaRepository;
import pe.com.megacentimetros.persona.service.ControlAsistenciaService;

@Service
public class ControlAsistenciaServiceImpl implements ControlAsistenciaService {

	private ControlAsistenciaRepository repositorio;

	public ControlAsistenciaServiceImpl(ControlAsistenciaRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<ControlAsistenciaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<ControlAsistenciaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public ControlAsistenciaEntity findById(Long id) {
		ControlAsistenciaEntity controlAsistencia = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ControlAsistencia con id " + id + " no existe"));
		return controlAsistencia;
	}
	@Override
	public ControlAsistenciaEntity add(ControlAsistenciaEntity obj) {
		obj.setEstado(true);
		if (obj.getSituacion() == null) {
			obj.setSituacion("PRESENTE");
		}
		return repositorio.save(obj);
	}
	@Override
	public ControlAsistenciaEntity update(ControlAsistenciaEntity obj, Long id) {
		ControlAsistenciaEntity objcon = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ControlAsistencia con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objcon, "codigo");
		return repositorio.save(objcon);
	}
	@Override
	public ControlAsistenciaEntity delete(Long id) {
		ControlAsistenciaEntity objcon = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ControlAsistencia con id " + id + " no existe"));
		objcon.setEstado(false);
		return repositorio.save(objcon);
	}
	@Override
	public ControlAsistenciaEntity enable(Long id) {
		ControlAsistenciaEntity objcon = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("ControlAsistencia con id " + id + " no existe"));
		objcon.setEstado(true);
		return repositorio.save(objcon);
	}
}
