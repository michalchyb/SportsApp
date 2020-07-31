package pl.project.service.mail;

import org.springframework.stereotype.Service;

@Service("consoleMailService")
public class ConsoleMailService implements MailService {

    @Override
    public void sendEmail(String from, String to, String subject, String text) {

        System.out.println("----------------------------------");
        System.out.println("---------Developer test-----------");
        System.out.println("Mail send from: " + from);
        System.out.println("Mail send to: " + to);
        System.out.println("Mail subject" + subject);
        System.out.println("Mail content :" + text);
        System.out.println("----------------------------------");
    }
}
