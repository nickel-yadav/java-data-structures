import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> sortedList = new ArrayList<>() {{ add(1); add(2); add(3); add(4); add(5); add(6); add(7); add(8);}};
        int targetIndex = binarySearch(sortedList, 6);
        List<Boolean> booleanList = new ArrayList<>() {{ add(false); add(false); add(false); add(true); add(true); add(true);}};
        int boundary = findBoundary(booleanList);
        System.out.println("The target can be found at" + targetIndex);
        System.out.println("First occurrence of true at index " + boundary);

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


}