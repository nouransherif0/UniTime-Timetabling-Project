import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class SubjectLookupServiceTest {

    SubjectLookupService service = new SubjectLookupService();

    @Test(expected = RuntimeException.class)
    public void testSubjectNotFound_throwsException() {
        List<String[]> emptyDB = Collections.emptyList();
        service.findSubjectTitle(emptyDB, "MATH");
    }


}