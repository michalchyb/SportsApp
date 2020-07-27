package pl.project.service.mail;

import org.springframework.stereotype.Service;
import pl.project.payload.response.MessageResponse;

@Service("consoleMailService")
public class ConsoleMailService implements MailService {
    @Override
    public void sendEmail(String mailReceiver, MessageResponse content) {
        System.out.println("----------------------------------");
        System.out.println("---------Developer test-----------");
        System.out.println("Mail send to: " + mailReceiver);
        System.out.println("Mail send from: ");
        System.out.println("Mail content :" + content.toString());
        System.out.println("----------------------------------");
    }
}
