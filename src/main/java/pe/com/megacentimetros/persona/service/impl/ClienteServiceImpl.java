package pe.com.megacentimetros.persona.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.persona.client.CatalogoFeignClient;
import pe.com.megacentimetros.persona.exception.ResourceNotFoundException;
import pe.com.megacentimetros.persona.entity.ClienteEntity;
import pe.com.megacentimetros.persona.repository.ClienteRepository;
import pe.com.megacentimetros.persona.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;

	public ClienteServiceImpl(ClienteRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<ClienteEntity> findAll() {
		List<ClienteEntity> lista = repositorio.findAll();
		for (ClienteEntity cliente : lista) {
			cliente.setTipodocumento(catalogoFeignClient.getTipoDocumento(cliente.getCodtipd()));
			if (cliente.getCodsex() != null) {
				cliente.setSexo(catalogoFeignClient.getSexo(cliente.getCodsex()));
			}
			if (cliente.getCoddis() != null) {
				cliente.setDistrito(catalogoFeignClient.getDistrito(cliente.getCoddis()));
			}
			cliente.setTipocliente(catalogoFeignClient.getTipoCliente(cliente.getCodtipcli()));
		}
		return lista;
	}
	@Override
	public List<ClienteEntity> findAllCustom() {
		List<ClienteEntity> lista = repositorio.findAllCustom();
		for (ClienteEntity cliente : lista) {
			cliente.setTipodocumento(catalogoFeignClient.getTipoDocumento(cliente.getCodtipd()));
			if (cliente.getCodsex() != null) {
				cliente.setSexo(catalogoFeignClient.getSexo(cliente.getCodsex()));
			}
			if (cliente.getCoddis() != null) {
				cliente.setDistrito(catalogoFeignClient.getDistrito(cliente.getCoddis()));
			}
			cliente.setTipocliente(catalogoFeignClient.getTipoCliente(cliente.getCodtipcli()));
		}
		return lista;
	}
	@Override
	public ClienteEntity findById(Long id) {
		ClienteEntity cliente = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente con id " + id + " no existe"));
		cliente.setTipodocumento(catalogoFeignClient.getTipoDocumento(cliente.getCodtipd()));
		if (cliente.getCodsex() != null) {
			cliente.setSexo(catalogoFeignClient.getSexo(cliente.getCodsex()));
		}
		if (cliente.getCoddis() != null) {
			cliente.setDistrito(catalogoFeignClient.getDistrito(cliente.getCoddis()));
		}
		cliente.setTipocliente(catalogoFeignClient.getTipoCliente(cliente.getCodtipcli()));
		return cliente;
	}
	@Override
	public ClienteEntity add(ClienteEntity obj) {
		obj.setEstado(true);
		if (obj.getFechaRegistro() == null) {
			obj.setFechaRegistro(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public ClienteEntity update(ClienteEntity obj, Long id) {
		ClienteEntity objcli = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objcli, "codigo", "fechaRegistro");
		return repositorio.save(objcli);
	}
	@Override
	public ClienteEntity delete(Long id) {
		ClienteEntity objcli = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente con id " + id + " no existe"));
		objcli.setEstado(false);
		return repositorio.save(objcli);
	}
	@Override
	public ClienteEntity enable(Long id) {
		ClienteEntity objcli = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente con id " + id + " no existe"));
		objcli.setEstado(true);
		return repositorio.save(objcli);
	}
}
