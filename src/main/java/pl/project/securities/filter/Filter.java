package pl.project.securities.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

public class Filter {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new JwtFilter());
        filterRegistrationBean.setUrlPatterns(Collections.singleton("/api/login/*"));
        return filterRegistrationBean;
    }
}
