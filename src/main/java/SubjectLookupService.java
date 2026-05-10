import java.util.List;

public class SubjectLookupService {

    public String findSubjectTitle(List<String[]> subjects, String name) {
        // subjects is a list of {abbreviation, title} pairs (simulating DB result)
        for (String[] subject : subjects) {
            if (subject[0].equalsIgnoreCase(name)) {
                return subject[1]; // return title
            }
        }
        // BEFORE change:
        return null;    }
}