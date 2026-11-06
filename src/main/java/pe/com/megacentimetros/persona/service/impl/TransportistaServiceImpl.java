package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.exception.ResourceNotFoundException;
import pe.com.megacentimetros.persona.entity.TransportistaEntity;
import pe.com.megacentimetros.persona.repository.TransportistaRepository;
import pe.com.megacentimetros.persona.service.TransportistaService;

@Service
public class TransportistaServiceImpl implements TransportistaService {

	private TransportistaRepository repositorio;

	public TransportistaServiceImpl(TransportistaRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<TransportistaEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<TransportistaEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public TransportistaEntity findById(Long id) {
		TransportistaEntity transportista = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transportista con id " + id + " no existe"));
		return transportista;
	}
	@Override
	public TransportistaEntity add(TransportistaEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public TransportistaEntity update(TransportistaEntity obj, Long id) {
		TransportistaEntity objtra = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transportista con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objtra, "codigo");
		return repositorio.save(objtra);
	}
	@Override
	public TransportistaEntity delete(Long id) {
		TransportistaEntity objtra = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transportista con id " + id + " no existe"));
		objtra.setEstado(false);
		return repositorio.save(objtra);
	}
	@Override
	public TransportistaEntity enable(Long id) {
		TransportistaEntity objtra = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transportista con id " + id + " no existe"));
		objtra.setEstado(true);
		return repositorio.save(objtra);
	}
}
