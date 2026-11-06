package pe.com.megacentimetros.persona.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.persona.entity.ProveedorEntity;
import pe.com.megacentimetros.persona.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorRestController {

	@Autowired
	private ProveedorService servicio;

	@GetMapping
	public List<ProveedorEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<ProveedorEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public ProveedorEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public ProveedorEntity add(@RequestBody ProveedorEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public ProveedorEntity update(@RequestBody ProveedorEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public ProveedorEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public ProveedorEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
