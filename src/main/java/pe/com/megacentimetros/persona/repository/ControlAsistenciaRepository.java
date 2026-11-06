package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.ControlAsistenciaEntity;

public interface ControlAsistenciaRepository extends JpaRepository<ControlAsistenciaEntity, Long> {

	@Query("select d from ControlAsistenciaEntity d where d.estado = true")
	List<ControlAsistenciaEntity> findAllCustom();
}
