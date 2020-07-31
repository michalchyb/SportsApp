package pl.project.service.mail;

public interface MailService {

    void sendEmail(String from, String to , String subject, String text);
}

