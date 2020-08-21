package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.model.Tri;

@Repository
public interface TriRepository extends JpaRepository<Tri, Long> {

}
