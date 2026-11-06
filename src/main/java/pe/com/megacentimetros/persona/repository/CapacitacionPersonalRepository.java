package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.CapacitacionPersonalEntity;

public interface CapacitacionPersonalRepository extends JpaRepository<CapacitacionPersonalEntity, Long> {

	@Query("select d from CapacitacionPersonalEntity d where d.estado = true")
	List<CapacitacionPersonalEntity> findAllCustom();
}
