import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ClassDuplicateCheckerTest {

    @Test
    public void testIsDuplicate_returnsTrueWhenDuplicateExists() {
        List<int[]> existing = new ArrayList<>();
        existing.add(new int[]{"CS101".hashCode(), 1});

        boolean result = ClassDuplicateChecker.isDuplicate("CS101", 1, existing);
        assertTrue(result);
    }

    @Test
    public void testIsDuplicate_returnsFalseWhenNoDuplicate() {
        List<int[]> existing = new ArrayList<>();
        existing.add(new int[]{"CS101".hashCode(), 1});

        boolean result = ClassDuplicateChecker.isDuplicate("MATH201", 2, existing);
        assertFalse(result);
    }

    @Test
    public void testIsDuplicate_returnsFalseWhenListIsEmpty() {
        List<int[]> existing = new ArrayList<>();

        boolean result = ClassDuplicateChecker.isDuplicate("CS101", 1, existing);
        assertFalse(result);
    }
}