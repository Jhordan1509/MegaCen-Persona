package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.client.CatalogoFeignClient;
import pe.com.megacentimetros.persona.exception.ResourceNotFoundException;
import pe.com.megacentimetros.persona.entity.PersonalEntity;
import pe.com.megacentimetros.persona.repository.PersonalRepository;
import pe.com.megacentimetros.persona.service.PersonalService;

@Service
public class PersonalServiceImpl implements PersonalService {

	private PersonalRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;

	public PersonalServiceImpl(PersonalRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<PersonalEntity> findAll() {
		List<PersonalEntity> lista = repositorio.findAll();
		for (PersonalEntity personal : lista) {
			personal.setTipodocumento(catalogoFeignClient.getTipoDocumento(personal.getCodtipd()));
			if (personal.getCodsex() != null) {
				personal.setSexo(catalogoFeignClient.getSexo(personal.getCodsex()));
			}
			if (personal.getCoddis() != null) {
				personal.setDistrito(catalogoFeignClient.getDistrito(personal.getCoddis()));
			}
		}
		return lista;
	}
	@Override
	public List<PersonalEntity> findAllCustom() {
		List<PersonalEntity> lista = repositorio.findAllCustom();
		for (PersonalEntity personal : lista) {
			personal.setTipodocumento(catalogoFeignClient.getTipoDocumento(personal.getCodtipd()));
			if (personal.getCodsex() != null) {
				personal.setSexo(catalogoFeignClient.getSexo(personal.getCodsex()));
			}
			if (personal.getCoddis() != null) {
				personal.setDistrito(catalogoFeignClient.getDistrito(personal.getCoddis()));
			}
		}
		return lista;
	}
	@Override
	public PersonalEntity findById(Long id) {
		PersonalEntity personal = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Personal con id " + id + " no existe"));
		personal.setTipodocumento(catalogoFeignClient.getTipoDocumento(personal.getCodtipd()));
		if (personal.getCodsex() != null) {
			personal.setSexo(catalogoFeignClient.getSexo(personal.getCodsex()));
		}
		if (personal.getCoddis() != null) {
			personal.setDistrito(catalogoFeignClient.getDistrito(personal.getCoddis()));
		}
		return personal;
	}
	@Override
	public PersonalEntity add(PersonalEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public PersonalEntity update(PersonalEntity obj, Long id) {
		PersonalEntity objper = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Personal con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objper, "codigo");
		return repositorio.save(objper);
	}
	@Override
	public PersonalEntity delete(Long id) {
		PersonalEntity objper = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Personal con id " + id + " no existe"));
		objper.setEstado(false);
		return repositorio.save(objper);
	}
	@Override
	public PersonalEntity enable(Long id) {
		PersonalEntity objper = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Personal con id " + id + " no existe"));
		objper.setEstado(true);
		return repositorio.save(objper);
	}
}
