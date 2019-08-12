package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.entity.Run;

import java.util.Optional;

public interface RunRepository extends JpaRepository<Run, Long> {
    Run findById(long id);

    Optional<Run> findRunByNameRun(String runName);

    void deleteByNameRun(String runName);
}
