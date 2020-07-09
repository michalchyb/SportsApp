package pl.project.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import pl.project.exception.ExtensionError;
import pl.project.exception.ResponseMessage;
import pl.project.model.FileInfo;
import pl.project.service.FilesStorageService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@Controller
@RequestMapping("/api/")
public class FilesController {

    private FilesStorageService filesStorageService;
    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif");


    public FilesController(FilesStorageService filesStorageService) {
        this.filesStorageService = filesStorageService;
    }


    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message;
        if (!contentTypes.contains(file.getContentType())) {
            throw new ExtensionError(contentTypes);
        }
        try {

            filesStorageService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getFilesList() {
        List<FileInfo> fileInfos = filesStorageService.loadAll().map(path -> {
            String fileName = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(fileName, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = filesStorageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<ResponseMessage> deleteByName(@PathVariable String fileName) {
        String message;
        if (!filesStorageService.delete(fileName)) {
            message = "Could not delete:  " + fileName;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(message));
        }
        message = "File  " + fileName + " deleted";
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    }
}