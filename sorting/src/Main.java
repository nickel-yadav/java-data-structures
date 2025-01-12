public class Main {
    public static void main(String[] args) {
       int[] unsortedList = {6,5,2,1,4,9,1};
        System.out.println("Unsorted list:");
        for (int j : unsortedList) {
            System.out.println(j);
        }
       int[] sortedList = bubbleSort(unsortedList);
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

    public static int[] selectionSort(int[] unsortedList) {
        for (int i=0; i<unsortedList.length; i++) {
            int minIndex = i;

            for (int j=i; j<unsortedList.length; j++) {
                if (unsortedList[j] < unsortedList[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = unsortedList[i];
            unsortedList[i] = unsortedList[minIndex];
            unsortedList[minIndex] = temp;
        }
        return unsortedList;
    }

    public static int[] bubbleSort(int[] unsortedList) {
        int n = unsortedList.length;
        for (int i=n-1; i>0; i--) {
            boolean swapped = false;
            for ( int j=0; j < i; j++) {
                if (unsortedList[j] > unsortedList[j+1]) {
                    int temp = unsortedList[j];
                    unsortedList[j] = unsortedList[j+1];
                    unsortedList[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                return unsortedList;
            }
        }
        return unsortedList;
    }
}