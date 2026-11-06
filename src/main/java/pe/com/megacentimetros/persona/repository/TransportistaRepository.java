package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.TransportistaEntity;

public interface TransportistaRepository extends JpaRepository<TransportistaEntity, Long> {

	@Query("select d from TransportistaEntity d where d.estado = true")
	List<TransportistaEntity> findAllCustom();
}
