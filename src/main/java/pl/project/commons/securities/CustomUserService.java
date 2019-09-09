package pl.project.commons.securities;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserService implements UserDetailsService {

    private UserAppRepository userAppRepository;

    public CustomUserService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserApp> userAppOptional = userAppRepository.findUserAppByName(name);
        userAppOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return userAppOptional.map(CustomUserDetails::new).get();
    }
}
