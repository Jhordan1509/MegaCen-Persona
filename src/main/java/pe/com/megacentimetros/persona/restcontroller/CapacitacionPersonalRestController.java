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
import pe.com.megacentimetros.persona.entity.CapacitacionPersonalEntity;
import pe.com.megacentimetros.persona.service.CapacitacionPersonalService;

@RestController
@RequestMapping("/api/capacitacionpersonal")
public class CapacitacionPersonalRestController {

	@Autowired
	private CapacitacionPersonalService servicio;

	@GetMapping
	public List<CapacitacionPersonalEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<CapacitacionPersonalEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public CapacitacionPersonalEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public CapacitacionPersonalEntity add(@RequestBody CapacitacionPersonalEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public CapacitacionPersonalEntity update(@RequestBody CapacitacionPersonalEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public CapacitacionPersonalEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public CapacitacionPersonalEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
