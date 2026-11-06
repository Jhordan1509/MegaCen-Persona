package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.ProveedorEntity;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {

	@Query("select d from ProveedorEntity d where d.estado = true")
	List<ProveedorEntity> findAllCustom();
}
