import java.util.Arrays;
import java.util.Comparator;

public class TestSort {
    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            int comparisons;
            int swaps;

            public int compare(Integer o1, Integer o2) {
                comparisons++;
                if (o1 - o2 > 0)
                    swaps++;
                System.out.println("Comparisons: " + comparisons);
                System.out.println("Swaps: " + swaps);
                return o1 - o2;
            }
        };

        //Integer[] testArray = {5,6,7,8,1,2,3,4};
        //int[] testArray = {4, 3, 1, 5, 2, 6, 7};

        int[] testArray = {432, 12, 65, 1, 7411, 55, 854, 9};

        Sorting.lsdRadixSort(testArray);
        System.out.println(Arrays.toString(testArray));



    }

}
