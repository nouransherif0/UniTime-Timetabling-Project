import org.junit.Test;
import static org.junit.Assert.*;

public class ImportTranslationsTokenTest {

    TokenValidator validator = new TokenValidator();

    // FAILS before change — no exception thrown when token is missing
    @Test(expected = IllegalStateException.class)
    public void testMissingToken_throwsException() {
        validator.resolveToken_after(); // ❌ FAIL — no exception thrown
    }
}