import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void getUniqueArrayFailCases() {
        getUniqueArrayTestFailSet1();
        getUniqueArrayTestFailSet2();
        getUniqueArrayTestFailSet3();
        getUniqueArrayTestFailSet4();
    }

    @Test
    public void getUniqueArrayPassCases() {
        getUniqueArrayTestPassSet1();
        getUniqueArrayTestPassSet2();
    }

    @Test
    public void descendingSortPassCases() {
        descendingSortDataSet1();
        descendingSortDataSet2();
        descendingSortDataSet3();
    }

    @Test
    public void getUniqueArrayTestFailSet1() {
        String[] input = {" "};
        String[] expectedOutput = {" "};
        getUniqueArrayFailTest(input, expectedOutput);
    }

    @Test
    public void getUniqueArrayTestFailSet2() {
        String[] input = {null};
        String[] expectedOutput = {null};
        getUniqueArrayFailTest(input, expectedOutput);
    }

    @Test
    public void getUniqueArrayTestFailSet3() {
        String[] input = {""};
        String[] expectedOutput = {""};
        getUniqueArrayFailTest(input, expectedOutput);
    }

    @Test
    public void getUniqueArrayTestFailSet4() {
        String[] input = {"K2\\SK1\\SSK2", "", };
        String[] expectedOutput = {"K2\\SK1\\SSK2", "", };
        getUniqueArrayFailTest(input, expectedOutput);
    }

    @Test
    public void getUniqueArrayTestPassSet1() {
        String[] input = {"K2\\SK1\\SSK2"};
        String[] expectedOutput = {"K2", "K2\\SK1", "K2\\SK1\\SSK2"};
        getUniqueArrayPassTest(input, expectedOutput);
    }

    @Test
    public void getUniqueArrayTestPassSet2() {
        String[] input = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        String[] expectedOutput = {
                "K1",
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        getUniqueArrayPassTest(input, expectedOutput);
    }

    @Test
    public void descendingSortDataSet1() {
        String[] departments = {
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };

        String[] expectedSortedDepartments = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        departmentsArrayInDescendingOrder(departments, expectedSortedDepartments);
    }

    @Test
    public void descendingSortDataSet2() {
        String[] departments = {
                "K1\\SK1\\SSK1",
                "K1\\SK2\\SSK2",
                "K2\\SK1\\SSK1",
                "K2\\SK2\\SSK2"
        };

        String[] expectedSortedDepartments = {
                "K2",
                "K2\\SK2",
                "K2\\SK1",
                "K2\\SK2\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK2\\SSK2",
                "K1\\SK1\\SSK1"
        };
        departmentsArrayInDescendingOrder(departments, expectedSortedDepartments);
    }

    @Test
    public void descendingSortDataSet3() {
        String[] departments = {
                "K1\\SK1",
                "K2\\SK1\\SSK1"
        };

        String[] expectedSortedDepartments = {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK1"
        };
        departmentsArrayInDescendingOrder(departments, expectedSortedDepartments);
    }

    private void getUniqueArrayPassTest(String[] input, String[] expectedOutput) {
        String[] actualOutput = solution.getUniqueArray(input);
        assertEquals(actualOutput.length, expectedOutput.length);
        for (String item : actualOutput) {
            assert Arrays.asList(expectedOutput).contains(item);
        }
        System.out.println("Input:\n" + Arrays.toString(input)
                + "\nExpected output:\n" + Arrays.toString(expectedOutput)
                + "\nActual output contains all elements from Expected output:\n" + Arrays.toString(actualOutput) + "\n");
    }

    private void getUniqueArrayFailTest(String[] input, String[] expectedOutput) {
        String[] actualOutput = solution.getUniqueArray(input);
        assertEquals(Arrays.toString(expectedOutput), Arrays.toString(actualOutput));
    }

    private void departmentsArrayInDescendingOrder(String[] departments, String[] expectedSortedDepartments) {
        System.out.println("Input departments:\n" + Arrays.toString(departments));

        String[] uniqueArray = solution.getUniqueArray(departments);

        String[] sortedArrayDesc =  solution.descendingSort(uniqueArray);

        System.out.println("Sorted departments:\n" + Arrays.toString(sortedArrayDesc));
        System.out.println("Expected sorted departments:\n" + Arrays.toString(expectedSortedDepartments) + "\n");
        
        assert sortedArrayDesc.length == expectedSortedDepartments.length;

        for (int i = 0; i < sortedArrayDesc.length; i++) {
            assertEquals(sortedArrayDesc[i], expectedSortedDepartments[i]);
        }
    }

}

