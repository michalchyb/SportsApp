package pl.project.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.project.model.Run;

import java.util.List;
import java.util.Optional;

public interface RunRepository extends JpaRepository<Run, Long> {

    Optional<Run> findRunByName(String name);

    @Query("Select r from Run r")
    List<Run> findAllRuns(Pageable page);

    void deleteById(Long id);

    List<Run> findRunsByDistance(Double distance);

    @Query(value = "SELECT *  from run r  WHERE r.distance = 5 limit 5",
            nativeQuery = true)
    List<Run> findLast5KmRuns();

    @Query(value = "SELECT *  from run r  WHERE r.distance = 10 limit 5",
            nativeQuery = true)
    List<Run> findLast10KmRuns();

    @Query(value = "SELECT *  from run r  WHERE r.distance = 21 limit 5",
            nativeQuery = true)
    List<Run> findLast21KmRuns();

}
