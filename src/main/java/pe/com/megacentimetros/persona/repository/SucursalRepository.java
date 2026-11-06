package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.SucursalEntity;

public interface SucursalRepository extends JpaRepository<SucursalEntity, Long> {

	@Query("select d from SucursalEntity d where d.estado = true")
	List<SucursalEntity> findAllCustom();
}
