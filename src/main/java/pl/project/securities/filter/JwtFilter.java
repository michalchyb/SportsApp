package pl.project.securities.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        ((HttpServletRequest) servletRequest).getHeader("Authorization");
        if (httpServletRequest == null || !((HttpServletRequest) servletRequest).getHeader("Authorization").startsWith("Bearer_")) {
            throw new ServletException("Wrong or empty header");
        } else {
            try {
                String token = ((HttpServletRequest) servletRequest).getHeader("Authorization").substring(7);
                Claims claims = Jwts.parser().setSigningKey("michal123").parseClaimsJws(token).getBody();
                servletRequest.setAttribute("claims", claims);
            }
            catch (Exception ex){
                throw new ServletException("Incorrect key");
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
