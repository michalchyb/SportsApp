package pl.project.commons.storage;

import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class LocalFileService {
    private static final Logger log = Logger.getLogger(LocalFileService.class.getName());

    private ServletContext servletContext;
    private String uploads;

    public LocalFileService(ServletContext servletContext) {
        this.servletContext = servletContext;
        createDirectory();
    }

    private void createDirectory() {
        uploads = servletContext.getRealPath("/uploads/");
        log.log(Level.INFO, uploads);

        Path path = Paths.get(uploads);
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
