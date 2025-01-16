import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> unsortedList = Arrays.asList(9,4,2,7,1,5,3);
        System.out.println("Unsorted list:");
        for (Integer item: unsortedList) {
            System.out.println(item);
        }
        List<Integer> sortedList = sortList(unsortedList);
        System.out.println("Sorted list:");
        for (Integer item: sortedList) {
            System.out.println(item);
        }
    }

    public static List<Integer> sortList(List<Integer> unsortedList) {
        quickSortListInterval(unsortedList, 0, unsortedList.size());
        return unsortedList;
    }

    public static List<Integer> mergeSortListInterval(List<Integer> unsortedList, int start, int end) {
        // Base condition where recursion bottoms out
        if (end - start <= 1) {
            return unsortedList.subList(start, end);
        }

        // Recursively divide each list into smaller lists
        int midpoint = (start + end)/2;
        List<Integer> leftList = mergeSortListInterval(unsortedList, start, midpoint);
        List<Integer> rightList = mergeSortListInterval(unsortedList, midpoint, end);

        ArrayList<Integer> resultList = new ArrayList<>();
        int leftPointer = 0, rightPointer = 0;

        // Merge lists through element comparison
        while (leftPointer < leftList.size() || rightPointer < rightList.size()) {
            // Condition where left list is completely filled
            if ( leftPointer == leftList.size()) {
                resultList.add(rightList.get(rightPointer));
                rightPointer++;
            }
            // Condition where right list is completely filled
            else if (rightPointer == rightList.size()) {
                resultList.add(leftList.get(leftPointer));
                leftPointer++;
            }
            else if (leftList.get(leftPointer) <= rightList.get(rightPointer)) {
                resultList.add(leftList.get(leftPointer));
                leftPointer++;
            } else {
                resultList.add(rightList.get(rightPointer));
                rightPointer++;
            }
        }
        return resultList;
    }

    public static void quickSortListInterval(List<Integer> unsortedList, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int pivot = unsortedList.get(end - 1);
        int startPtr = start, endPtr = end - 1;

        while ( startPtr < endPtr) {
            while (unsortedList.get(startPtr) < pivot && startPtr < endPtr) {
                startPtr++;
            }

            while (unsortedList.get(endPtr) >= pivot && startPtr < endPtr) {
                endPtr--;
            }

            if ( startPtr != endPtr) {
                int temp = unsortedList.get(startPtr);
                unsortedList.set(startPtr, unsortedList.get(endPtr));
                unsortedList.set(endPtr, temp);
            }
        }

        int temp = unsortedList.get(startPtr);
        unsortedList.set(startPtr, unsortedList.get(end - 1));
        unsortedList.set(end -1, temp);

        quickSortListInterval(unsortedList, start, startPtr);
        quickSortListInterval(unsortedList, startPtr + 1, end);
    }
}