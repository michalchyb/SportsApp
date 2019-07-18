package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.project.entity.Triathlon;

public interface TriathlonRepository extends JpaRepository<Triathlon, Long> {
	Triathlon findById(long id);
}
