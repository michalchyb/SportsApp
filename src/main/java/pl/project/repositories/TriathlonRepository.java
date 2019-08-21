package pl.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.models.Triathlon;

import java.util.List;
import java.util.Optional;

public interface TriathlonRepository extends JpaRepository<Triathlon, Long> {
	Triathlon findById(long id);

	Optional<Triathlon> findRunByNameRun(String runName);

	List<Triathlon> findTriathlonsByDistance(Double distance);

	void deleteByNameRun(String runName);
}

