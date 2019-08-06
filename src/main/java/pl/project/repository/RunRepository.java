package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.entity.Run;

public interface RunRepository extends JpaRepository<Run, Long> {
	Run findById(long id);
}
