package pl.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.project.models.Run;
import pl.project.models.Triathlon;

import java.util.Optional;

public interface TriathlonRepository extends JpaRepository<Triathlon, Long> {
	Triathlon findById(long id);

	Optional<Run> findRunByNameTriathlon(String runName);
	void deleteByNameTriathlon(String runName);
}
