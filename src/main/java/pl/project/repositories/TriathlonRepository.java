package pl.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.project.models.Triathlon;

public interface TriathlonRepository extends JpaRepository<Triathlon, Long> {
	Triathlon findById(long id);
}
