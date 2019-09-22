package pl.project.commons.storage;

import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.logging.Logger;

@Service
public class LocalFileService {
    private static final Logger log = Logger.getLogger(LocalFileService.class.getName());

    private ServletContext servletContext;
    private String uploads;

    public LocalFileService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
