package pl.project.commons.storage;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public List<LocalFile> getFilesFromDirector() throws IOException {

        return Files.walk(Paths.get(uploads))
                .filter(Files::isRegularFile)
                .map(f -> {
                    try {
                        BasicFileAttributes basicFileAttributes = Files.
                                readAttributes(f.toAbsolutePath(), BasicFileAttributes.class);
                        String downloadUri = ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("/api/files/download")
                                .path(f.getFileName().toString())
                                .toUriString();

                        String deleteUri = ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("/api/files/delete")
                                .path(f.getFileName().toString())
                                .toUriString();

                        return LocalFile.builder()
                                .name(f.getFileName().toString())
                                .creationTime(basicFileAttributes.creationTime().toString())
                                .lastModified(basicFileAttributes.lastModifiedTime().toString())
                                .size(basicFileAttributes.size())
                                .downloadUri(downloadUri)
                                .deleteUri(deleteUri)
                                .fileType(Files.probeContentType(f.toAbsolutePath()))
                                .build();


                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }).collect(Collectors.toList());
    }

    public void uploadFile(MultipartFile multipartFile) throws IOException {
        Path path = Paths.get(uploads + multipartFile.getOriginalFilename());
        Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    }

    public void deleteFile(String fileName) {
        File file = new File(uploads + fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    public File downloadFile(String fileName) {
        return new File(uploads + fileName);
    }

    public String getUploads() {
        return uploads;
    }
}
