import org.junit.Test;
import static org.junit.Assert.*;

public class DataImportFormTest {

    @Test
    public void testCopyConstructor_copiesAllFields() {
        DataImportForm original = new DataImportForm();
        original.setAddress("123 Main St");
        original.setEmail(true);

        DataImportForm copy = new DataImportForm(original); // no copy constructor → FAILS here

        assertEquals(original.getAddress(), copy.getAddress());
        assertEquals(original.getEmail(),   copy.getEmail());
        assertNotSame(original, copy);
    }
}