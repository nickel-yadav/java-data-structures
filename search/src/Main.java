import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> sortedList = new ArrayList<>() {{ add(1); add(2); add(3); add(4); add(5); add(6); add(7); add(8);}};
        int target = 6;
        int targetIndex = binarySearch(sortedList, target);
        System.out.println("The target can be found at" + targetIndex);
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


}