import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       int[] unsortedList = {6,5,2,1,4,9,1};
        System.out.println("Unsorted list:");
        for (int j : unsortedList) {
            System.out.println(j);
        }
       int[] sortedList = insertionSort(unsortedList);
        System.out.println("Sorted list");
        for (int i : sortedList) {
            System.out.println(i);
        }
    }

    public static int[] insertionSort(int[] unsortedList) {
        // Iterate over the array
        for ( int i=0; i<unsortedList.length; i++) {
            int currentIndex = i;
            // Compare the current element with the preceding element, starting from first element
            while (currentIndex > 0 && unsortedList[currentIndex] < unsortedList[currentIndex - 1]) {
                int temp = unsortedList[currentIndex - 1];
                unsortedList[currentIndex - 1] =  unsortedList[currentIndex];
                unsortedList[currentIndex] = temp;
                currentIndex--;
            }
        }
        return unsortedList;
    }

    //TODO: Implement selectionSort
    public static void selectionSort(ArrayList<Integer> unsortedList) {}

    //TODO: Implement bubbleSort
    public static void bubbleSort(ArrayList<Integer> unsortedList) {}
}