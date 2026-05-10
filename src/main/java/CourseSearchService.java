import java.util.ArrayList;
import java.util.List;

public class CourseSearchService {

    // Each String[] = {courseNbr, sessionId}
    public List<String> searchByName(String keyword, String sessionId, List<String[]> allCourses) {
        List<String> result = new ArrayList<>();
        for (String[] course : allCourses) {
            if (course[1].equals(sessionId) &&
                    course[0].toLowerCase().contains(keyword.toLowerCase())) {
                result.add(course[0]);
            }
        }
        return result;
    }
}