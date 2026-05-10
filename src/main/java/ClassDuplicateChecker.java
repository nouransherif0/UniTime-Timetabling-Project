import java.util.List;

public class ClassDuplicateChecker {

    public static boolean isDuplicate(String subpart, int sectionNumber, List<int[]> existing) {
        // existing is a list of {subpart hashcode, sectionNumber} pairs simulating DB
        for (int[] entry : existing) {
            if (entry[0] == subpart.hashCode() && entry[1] == sectionNumber) {
                return true;
            }
        }
        return false;
    }
}