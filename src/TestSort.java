import java.util.Comparator;

public class TestSort {
    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            int comparisons;
            int swaps;
            public int compare(Integer o1, Integer o2) {
                comparisons ++;
                if(o1-o2 > 0)
                    swaps++;
                System.out.println("Comparisons: " + comparisons);
                System.out.println("Swaps: " + swaps);
                return o1 - o2;
            }
        };

        Integer[] testArray = {5,6,7,8,1,2,3,4};
    }
}
