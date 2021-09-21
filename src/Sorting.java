import java.util.*;

/**
 * Implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
      */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {

        // Step 1: Partition array into halves
        if (arr.length <= 1)
            return;
        else {
            int length = arr.length;
            int middle = length / 2;

            T[] Left = (T[]) new Object[middle];
            for (int l = 0; l < middle; l++)
                Left[l] = arr[l];

            T[] Right = (T[]) new Object[(length - middle)];
            for (int r = middle; r < length; r++)
                Right[r-middle] = arr[r];

            mergeSort(Left, comparator);
            mergeSort(Right, comparator);

            // Step 2: merging two halves
            int i = 0;
            int j = 0;
            while (i < Left.length && j < Right.length) {

                if (comparator.compare(Left[i], Right[j]) <= 0) {
                    arr[i + j] = Left[i];
                    i++;
                } else {
                    arr[i + j] = Right[j];
                    j++;
                }
            }

                // Step 3: empty remaining subarray
                while (i < Left.length) {
                    arr[i + j] = Left[i];
                    i++;
                }
                while(j < Right.length){
                    arr[i + j] = Right[j];
                    j++;
                }
        }
    }


    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     */
    public static void lsdRadixSort(int[] arr) {
        // Each loop will sort the array by its least significant digit. then index one lsd.

        // Step 1: determine the greatest magnitude of integer in the array
        int magnitude = mag(arr);

        // Step 2: create an ArrayQueue where each entry is the head of a linked list node.
        Queue<Integer>[] buckets = new Queue[19];

        for(int j = 0; j < magnitude; j++){
            for(int k = 0; k < arr.length; k++){
                int digitIndex = lsdIndex(arr[k], j);

                // If bucket[index] is null, create a linked list at that index
                if(buckets[digitIndex+9] == null)
                    buckets[digitIndex+9] = new LinkedList<Integer>();

                // Add the entry to the linked list at that index
                buckets[digitIndex + 9].add(arr[k]);
            }

            // Step 3: iterate through the buckets array and "empty" each bucket linked list into the original array
            int index = 0;
            for(Queue<Integer> bucket: buckets){
                while(bucket != null && !bucket.isEmpty()){
                    arr[index] = bucket.remove();
                    index ++;
                }
            }
        }
    }

    // Helper method to determine the greatest magnitude of Integers in the array
    private static int mag(int[] arr){
        int magnitude = 1;

        for(int i = 0; i < arr.length; i++){
            int loops = 1;
            int current = arr[i];
            while(current > 0) {
                current = current / 10;
                loops++;
            }
            if(loops > magnitude)
                magnitude = loops;
        }
        return magnitude;
    }

    // Helper method to pull out the lsd of the iteration loop for Radix sort
    private static int lsdIndex(int num, int index){
        for(int i = 0; i < index; i++)
            num /= 10;

        num %= 10;
        return num;
    }
}