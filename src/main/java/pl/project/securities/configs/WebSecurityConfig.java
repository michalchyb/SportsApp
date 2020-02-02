package pl.project.securities.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.project.securities.filter.JwtFilter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/test2").authenticated()// zalogowany
                .antMatchers("/test3").hasRole("ADMIN")
                .and()
                .addFilter(new JwtFilter(authenticationManager()));
    }
}
