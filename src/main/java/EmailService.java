import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailService {
    public static void sendTimetableChangeNotification(String toEmail,
                                                       String courseName,
                                                       String changeDetails) {
        Properties props = new Properties();
        props.put("mail.smtp.host", System.getProperty("smtp.host", "localhost"));
        props.put("mail.smtp.port", System.getProperty("smtp.port", "25"));
        Session session = Session.getInstance(props);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("timetable@university.edu"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Timetable Change: " + courseName);
            message.setText("Dear student,\n\nThe following change was made:\n\n"
                    + changeDetails + "\n\nPlease check the timetable system.");
            Transport.send(message);
        } catch (MessagingException e) {
            System.err.println("Failed to send email notification: " + e.getMessage());
        }
    }
}