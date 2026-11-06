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
import pe.com.megacentimetros.persona.entity.PersonalEntity;
import pe.com.megacentimetros.persona.service.PersonalService;

@RestController
@RequestMapping("/api/personal")
public class PersonalRestController {

	@Autowired
	private PersonalService servicio;

	@GetMapping
	public List<PersonalEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<PersonalEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public PersonalEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public PersonalEntity add(@RequestBody PersonalEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public PersonalEntity update(@RequestBody PersonalEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public PersonalEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public PersonalEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
