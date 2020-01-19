package pl.project.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.project.commons.storage.LocalFile;
import pl.project.commons.storage.LocalFileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LocalFileController {

    private LocalFileService localFileService;

    public LocalFileController(LocalFileService localFileService) {
        this.localFileService = localFileService;
    }

    @GetMapping("/files")
    public List<LocalFile> getResources() throws IOException {
        return localFileService.getFilesFromDirector();
    }

    @PostMapping("/files")
    public void uploadFile(@RequestParam MultipartFile multipartFile) throws IOException {
        localFileService.uploadFile(multipartFile);
    }

    @GetMapping("/files/download/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename) throws IOException {
        File file = localFileService.downloadFile(filename);
        Resource resource = new UrlResource(localFileService.getUploads() + filename);
        String contentType = Files.probeContentType(file.toPath());
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" " + file.getName() + "\"")
                .contentLength(file.length())
                .body(resource);
    }

    @DeleteMapping("files/delete/{filename}")
    public void deleteFile(@PathVariable String filename) {
        localFileService.deleteFile(filename);
    }

}
