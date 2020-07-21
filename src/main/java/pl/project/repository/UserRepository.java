package pl.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUserName(String userName);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
