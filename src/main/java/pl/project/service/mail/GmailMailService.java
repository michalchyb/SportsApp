package pl.project.service.mail;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.project.payload.response.MessageResponse;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Getter
@Service("gmailMailService")
public class GmailMailService implements MailService {

    private static final String SUBJECT = "Registration success";

    @Value("${spring.mail.username}")
    private String ORIGIN_MAIL_USERNAME;

    @Value("${spring.mail.host}")
    private String ORIGIN_MAIL_HOST;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String mailReceiver, MessageResponse content) {

        MimeMessage mail = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mail, true);

            mimeMessageHelper.setSubject(SUBJECT);
            mimeMessageHelper.setFrom(getORIGIN_MAIL_USERNAME() + getORIGIN_MAIL_HOST());
            mimeMessageHelper.setTo(mailReceiver);
            mimeMessageHelper.setText(content.toString());

            javaMailSender.send(mail);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
