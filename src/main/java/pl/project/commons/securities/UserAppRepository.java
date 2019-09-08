package pl.project.commons.securities;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.models.securities.UserApp;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Integer> {


    Optional<UserApp> findUserAppByName(String name);
}
