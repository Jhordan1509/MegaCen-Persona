package pe.com.megacentimetros.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.persona.entity.PersonalEntity;

public interface PersonalRepository extends JpaRepository<PersonalEntity, Long> {

	@Query("select d from PersonalEntity d where d.estado = true")
	List<PersonalEntity> findAllCustom();
}
