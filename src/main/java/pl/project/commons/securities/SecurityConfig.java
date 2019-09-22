package pl.project.commons.securities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomUserService customUserService;
    private PasswordEncoder passwordEncoder;

    public SecurityConfig(CustomUserService customUserService, PasswordEncoder passwordEncoder) {
        this.customUserService = customUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable(); // dostep dla wszystkich ip 
        http.authorizeRequests()
                .antMatchers("/login**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/signig")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler((req, res, auth) -> {
                    for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
                        grantedAuthority.getAuthority();
                    }
                    res.sendRedirect("/");
                })
                .failureHandler((req, res, exception) -> {
                    String errorMessage;
                    if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
                        errorMessage = exception.getMessage();
                    } else {
                        errorMessage = exception.getMessage();
                    }
                    req.getSession().setAttribute("message", errorMessage);
                    res.sendRedirect("/login");
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req, res, auth) -> {
                    res.sendRedirect("login");
                })
                .permitAll()
                .and()
                .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
