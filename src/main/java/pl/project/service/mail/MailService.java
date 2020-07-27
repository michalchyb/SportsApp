package pl.project.service.mail;

import pl.project.payload.response.MessageResponse;

public interface MailService {

    void sendEmail(String to, MessageResponse content);
}
