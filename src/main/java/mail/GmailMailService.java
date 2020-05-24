package mail;

import configuration.MailConfiguration;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.InterfaceAddress;

public class GmailMailService implements MailService {

    private final MailConfiguration mailConfiguration;

    public GmailMailService(MailConfiguration mailConfiguration){
        this.mailConfiguration = mailConfiguration;
    }

    @Override
    public void sendEmail(Email email) {
        Session session = mailConfiguration.createSession();
        try {
            MimeMessage message = new MimeMessage(session);
            message.setText(email.getConcent());
            message.setSubject(email.getSubject());
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getMailAdress()));
            Transport.send(message);
            System.out.println("wyslane");

        }catch (MessagingException e){
            e.printStackTrace();
        }

    }
}
