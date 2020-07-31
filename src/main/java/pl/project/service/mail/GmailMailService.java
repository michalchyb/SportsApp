package pl.project.service.mail;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Getter
@Service("gmailMailService")
public class GmailMailService implements MailService {

    @Value("${spring.mail.host}")
    private String ORIGIN_MAIL_HOST;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String from, String to, String subject, String content) {

        MimeMessage mail = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mail, true);

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(content);

            javaMailSender.send(mail);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
