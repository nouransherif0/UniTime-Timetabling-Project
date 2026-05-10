import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CourseSearchServiceTest {

    CourseSearchService service = new CourseSearchService();

    @Test
    public void testSearchByName_returnsMatchingCourses() {
        List<String[]> db = new ArrayList<>();
        db.add(new String[]{"CS101", "1"});
        db.add(new String[]{"CS202", "1"});
        db.add(new String[]{"MATH101", "1"});

        List<String> result = service.searchByName("cs", "1", db);
        assertEquals(2, result.size());
        assertTrue(result.contains("CS101"));
        assertTrue(result.contains("CS202"));
    }

    @Test
    public void testSearchByName_caseInsensitive() {
        List<String[]> db = new ArrayList<>();
        db.add(new String[]{"CS101", "1"});

        List<String> result = service.searchByName("CS", "1", db);
        assertEquals(1, result.size());
    }

    @Test
    public void testSearchByName_returnsEmptyWhenNoMatch() {
        List<String[]> db = new ArrayList<>();
        db.add(new String[]{"CS101", "1"});

        List<String> result = service.searchByName("MATH", "1", db);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchByName_filtersBySessionId() {
        List<String[]> db = new ArrayList<>();
        db.add(new String[]{"CS101", "1"});
        db.add(new String[]{"CS202", "2"}); // different session

        List<String> result = service.searchByName("cs", "1", db);
        assertEquals(1, result.size());
        assertTrue(result.contains("CS101"));
    }
}