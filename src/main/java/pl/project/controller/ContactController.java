package pl.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.model.ContactRequest;
import pl.project.service.mail.MailService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Value("${spring.mail.username}")
    private String ORIGIN_MAIL_USERNAME;

    @Autowired
    @Qualifier("gmailMailService")
    private MailService mailService;

    @PostMapping(value = "/contact",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void sendContactMail(@Valid @RequestBody ContactRequest contactRequest) {
        mailService.sendEmail( contactRequest.getEmail(),ORIGIN_MAIL_USERNAME, contactRequest.getSubject(), contactRequest.getMessage());
    }
}
