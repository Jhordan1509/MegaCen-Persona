package pe.com.megacentimetros.persona.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-catalogo", url = "http://localhost:9091/pmega/api/")
public interface CatalogoFeignClient {
	@GetMapping("/sexo/{id}")
	Object getSexo(@PathVariable("id") Long id);

	@GetMapping("/tipodocumento/{id}")
	Object getTipoDocumento(@PathVariable("id") Long id);

	@GetMapping("/distrito/{id}")
	Object getDistrito(@PathVariable("id") Long id);

	@GetMapping("/tipocliente/{id}")
	Object getTipoCliente(@PathVariable("id") Long id);
}
