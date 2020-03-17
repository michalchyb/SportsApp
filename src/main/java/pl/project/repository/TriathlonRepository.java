package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.project.model.Triathlon;

import java.util.List;
import java.util.Optional;

public interface TriathlonRepository extends JpaRepository<Triathlon, Long> {
    Triathlon findById(long id);

    Optional<Triathlon> findRunByNameRun(String runName);

    List<Triathlon> findTriathlonsByDistance(Double distance);

    void deleteByNameRun(String runName);

    @Query(value = "SELECT *  from run t  WHERE t.distance = 28.25 limit 5",
            nativeQuery = true)
    List<Triathlon> findLast2825KmRuns();

    @Query(value = "SELECT *  from run t  WHERE t.distance = 56.50 limit 5",
            nativeQuery = true)
    List<Triathlon> findLast5650KmRuns();

    @Query(value = "SELECT *  from run t  WHERE t.distance = 112.99 limit 5",
            nativeQuery = true)
    List<Triathlon> findLast11299KmRuns();

}

