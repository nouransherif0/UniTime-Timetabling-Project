import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class TimetablePdfExporterTest {

    @Test
    public void testExport_generatesPdfSuccessfully() throws Exception {
        List<String[]> rows = new ArrayList<>();
        rows.add(new String[]{"CS101", "001", "Room A", "Mon 9-11", "Dr. Smith"});
        rows.add(new String[]{"MATH201", "002", "Room B", "Tue 10-12", "Dr. Jones"});

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TimetablePdfExporter.export(rows, out);

        byte[] pdf = out.toByteArray();
        assertTrue("PDF should not be empty", pdf.length > 0);

        String header = new String(pdf, 0, 4);
        assertEquals("%PDF", header);
    }
}