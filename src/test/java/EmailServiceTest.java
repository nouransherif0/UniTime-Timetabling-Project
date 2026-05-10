import org.junit.Test;
import static org.junit.Assert.*;

public class EmailServiceTest {

    @Test
    public void testSendTimetableChangeNotification_doesNotThrow() {

        try {
            EmailService.sendTimetableChangeNotification(
                    "student@university.edu",
                    "CS101",
                    "Room changed from A101 to B202"
            );
            assertTrue(true);
        } catch (Exception e) {
            fail("Method should not throw any exception, but threw: " + e.getMessage());
        }
    }
}