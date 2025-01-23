import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> sortedList = new ArrayList<>() {{ add(1); add(2); add(3); add(4); add(5); add(5); add(6); add(7); add(8);}};
        System.out.println("First not smaller index " + firstNotSmaller(sortedList, 4));

    }


    public static int binarySearch(List<Integer> arr, int target) {
      int left = 0;
      int right = arr.size() - 1;
      while (left <= right) {
          int midpoint = left + (right - left) / 2;
          if (target == arr.get(midpoint)) {
              return midpoint;
          }
          if (target > arr.get(midpoint)) {
              left = midpoint + 1;
          }
          else {
              right = midpoint - 1 ;
          }
      }
      return -1;
    }

    public static int findBoundary(List<Boolean> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;
        while (left <= right) {
        int mid = left + (right - left) / 2;
            if (arr.get(mid)) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static int firstNotSmaller(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) >= target) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1; // Dump the left mid, insignificant operation
            }
        }
        return boundaryIndex;
    }

}