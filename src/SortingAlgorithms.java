import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {

    // Variables to count comparisons and swaps
    private static long comparisons;
    private static long swaps;

    // Reset counters
    public static void resetCounters() {
        comparisons = 0;
        swaps = 0;
    }

    // Get number of comparisons
    public static long getComparisons() {
        return comparisons;
    }

    // Get number of swaps
    public static long getSwaps() {
        return swaps;
    }

    // Heap Sort

    public static void heapSort(int[] array) {
        resetCounters(); // Reset counters before sorting
        int n = array.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Heap sort
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max element) with the last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            swaps++; // Increment swap count

            // Heapify the reduced heap
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // Increment comparison count
        comparisons++;
        // If left child is larger than root
        if (left < n && array[left] > array[largest])
            largest = left;

        // Increment comparison count
        comparisons++;
        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            // Swap root with largest
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            swaps++; // Increment swap count

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    // Quick Sort

    public static void quickSort(int[] array) {
        resetCounters(); // Reset counters before sorting
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition the array
            int pi = partition(array, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Increment comparison count
            comparisons++;
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                swaps++; // Increment swap count
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        swaps++; // Increment swap count

        return i + 1;
    }

    // Utility function to print an array
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
