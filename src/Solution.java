import java.util.*;

public class Solution {

    public String[] getUniqueArray(String[] departments) {

        // Check that input data is correct
        // Iterate on each department path in departments array
            // Save to HashSet each whole path
                // Cut each division from departments tail with StringBuilder
                // Save to HashSet each cut-off path

        if (departmentsValidationFailCases(departments)) {
            System.out.println("Incorrect input, please check the departments array.\n" + Arrays.toString(departments) + "\n");
            return departments;
        }

        Set<String> uniqueSet = new HashSet<>();

        // Iterate
            // Add whole path to set -> "K2\\SK1\\SSK2"
            // Separate each divisions in array to find the tail -> ["K2", "SK1", "SSK2"]

        for (String department : departments) {
            uniqueSet.add(department);
            String[] splitDiv = department.split("\\\\");

            // Start from tail -> j = 2
            // Use StringBuilder to delete division from tail
            // Builder receives whole path -> "K2\\SK1\\SSK2"
            // Find index of "SSK2"
            // Delete area from "\SSK2" to length of whole path
            // Add reminder to HashSet "K2\\SK1"

            for (int j = splitDiv.length - 1; j > 0; j--) {
                StringBuilder builder = new StringBuilder(department);
                int separatorIdx = builder.indexOf(splitDiv[j]);
                builder.delete(separatorIdx - 1, department.length());
                uniqueSet.add(builder.toString());
            }
        }
        // Convert result to a static array
        String[] result = new String[uniqueSet.size()];
        result = uniqueSet.toArray(result);
        return result;
    }

    private boolean departmentsValidationFailCases(String[] departments) {
        List<String> depList = new ArrayList<>(Arrays.asList(departments));

        return (depList.contains("")
                || depList.contains(" ")
                || depList.contains(null)
                || departments.length == 0);
    }

    public String[] descendingSort(String[] departments) {
        List<String> list = Arrays.asList(departments);
        list.sort((o1, o2) -> {

            // Split each division path to subdivisions
            // Iterate on the shortest division path
                // Compare each element
                // If elements are different -> return and swap
                // Compare length
                // If length has difference -> return and swap
                // In other case continue
            // If Iteration finished return 0;

            String[] d1 = o1.split("\\\\");
            String[] d2 = o2.split("\\\\");

            int result = 0;
            for (int i = 0; i < Math.min(d1.length, d2.length); i++) {
                result = d2[i].compareTo(d1[i]);
                if (result != 0) return result;
                if (d1.length != d2.length) return d1.length < d2.length ? -1 : 1;
            }
            return result;
        });
        return departments;
    }
}
