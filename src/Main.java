import java.util.Random;

public class Main {


    public static void main(String[] args) {
        // Create arrays
        int[] randomArray = generateRandomArray(50);
        int[] ascendingArray = generateAscendingArray(50);
        int[] descendingArray = generateDescendingArray(50);

        // Sort arrays using Heap Sort
        System.out.println("Heap Sort:");
        testAndPrint(randomArray.clone(), "Random Array");
        testAndPrint(ascendingArray.clone(), "Ascending Array");
        testAndPrint(descendingArray.clone(), "Descending Array");

        // Sort arrays using Quick Sort
        System.out.println("\nQuick Sort:");
        testAndPrint(randomArray.clone(), "Random Array");
        testAndPrint(ascendingArray.clone(), "Ascending Array");
        testAndPrint(descendingArray.clone(), "Descending Array");
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // Generate random numbers between 0 and 99
        }
        return array;
    }

    public static int[] generateAscendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] generateDescendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i - 1;
        }
        return array;
    }

    public static void testAndPrint(int[] array, String label) {
        SortingAlgorithms.resetCounters(); // Reset counters before sorting
        System.out.println(label + ":");
        System.out.println("Before sorting:");
        SortingAlgorithms.printArray(array);

        // Perform heap sort
        SortingAlgorithms.heapSort(array);
        System.out.println("After sorting:");
        SortingAlgorithms.printArray(array);
        System.out.println("Number of comparisons: " + SortingAlgorithms.getComparisons());
        System.out.println("Number of swaps: " + SortingAlgorithms.getSwaps());
    }
}
