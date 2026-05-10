import org.junit.Test;
import static org.junit.Assert.*;

public class BorderStyleCheckerTest {

    BorderStyleChecker checker = new BorderStyleChecker();

    // PASSES after fix — correct && operator used
    @Test
    public void testThickTop_appliedWhenDyZeroAndHeader() {
        assertTrue(checker.shouldApplyThickTop_after(0, true));   // dy=0, isHeader=true → true
        assertFalse(checker.shouldApplyThickTop_after(1, true));  // dy=1 → false
        assertFalse(checker.shouldApplyThickTop_after(0, false)); // not header → false
        assertFalse(checker.shouldApplyThickTop_after(1, false)); // neither → false
    }
}