import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.OutputStream;
import java.util.List;

public class TimetablePdfExporter {
    public static void export(List<String[]> rows, OutputStream out) throws Exception {
        Document doc = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(doc, out);
        doc.open();
        doc.add(new Paragraph("University Timetable",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
        doc.add(Chunk.NEWLINE);
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        String[] headers = {"Course", "Section", "Room", "Time", "Instructor"};
        for (String h : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(h,
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            cell.setBackgroundColor(new java.awt.Color(200, 220, 240));
            table.addCell(cell);
        }
        for (String[] row : rows) {
            for (String cell : row) {
                table.addCell(new Phrase(cell,
                        FontFactory.getFont(FontFactory.HELVETICA, 9)));
            }
        }
        doc.add(table);
        doc.close();
    }
}