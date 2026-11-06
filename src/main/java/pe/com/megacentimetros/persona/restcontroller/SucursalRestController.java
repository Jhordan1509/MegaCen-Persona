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
import pe.com.megacentimetros.persona.entity.SucursalEntity;
import pe.com.megacentimetros.persona.service.SucursalService;

@RestController
@RequestMapping("/api/sucursal")
public class SucursalRestController {

	@Autowired
	private SucursalService servicio;

	@GetMapping
	public List<SucursalEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<SucursalEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public SucursalEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public SucursalEntity add(@RequestBody SucursalEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public SucursalEntity update(@RequestBody SucursalEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public SucursalEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public SucursalEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
