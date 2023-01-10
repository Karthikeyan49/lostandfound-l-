package test;
import com.sun.mail.smtp.SMTPMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

public class Mail {
public static void main(String[] args) throws Exception{
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "587");
    props.put("mail.smtp.socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "587");

    Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("deviljoker884@gmail.com","Steve@49");
        }
    });

    try {

        SMTPMessage message = new SMTPMessage(session);
        message.setFrom(new InternetAddress(" @gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                                 InternetAddress.parse( "karthikeyansenthilkumar0@gmail.com" ));

        message.setSubject("Testing Subject");
        message.setText("This is Test mail");
        message.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);
        int returnOption = message.getReturnOption();
        System.out.println(returnOption);        
        Transport.send(message);
        System.out.println("sent");

    }
     catch (MessagingException e) {
        throw new RuntimeException(e);         
     }
  }
}
/*import com.sun.mail.smtp.SMTPMessage;
import java.util.Properties;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

public class Mail{

    Session newSession=null;
    MimeMessage mimemsg=null;
    public static void main(String[] arg) throws AddressException, MessagingException{
        Mail m=new Mail();
        m.setupserverproperty();
        m.draftflow();
        m.sendemail();
    }

    private void sendemail() throws MessagingException {
        String frouser="deviljoker884@gmail.com";
        String fromuserpassword="Steve@49";
        String emailhost="smtp.gmail.com";
        System.out.println("ok");
        Transport transport=newSession.getTransport("smtp");
        transport.connect(emailhost,frouser,fromuserpassword);
        System.out.println("ok");
        transport.sendMessage(mimemsg,mimemsg.getAllRecipients());
        transport.close();
        System.out.println("email sussffully recevied");
    }

    private MimeMessage draftflow() throws AddressException, MessagingException {
        String emailreceptents="karthikeyansenthilkumar0@gmail.com";
        String subject="textfield";
        String body="body of the mail";
        mimemsg=new MimeMessage(newSession);
        mimemsg.addRecipient(Message.RecipientType.TO,new InternetAddress(emailreceptents));
        mimemsg.setSubject(subject);
        MimeBodyPart bodypart=new MimeBodyPart();
        bodypart.setContent(body,"html/text");
        MimeMultipart multipart=new MimeMultipart(); 
        multipart.addBodyPart(bodypart);
        mimemsg.setContent(multipart);
        return mimemsg;
    }

    private void setupserverproperty() {
        Properties properties=System.getProperties();
        properties.put("mail.smtp.port","587");
        properties.put("mail.smpt.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        newSession = Session.getDefaultInstance(properties, null);
    }
}
*/