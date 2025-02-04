import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> mountainArray = new ArrayList<>() {{ add(1); add(2); add(3); add(4); add(3); add(2); add(1);}};
        System.out.println("Peak element" + peakOfMountainArray(mountainArray));
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

    public static int findFirstOccurrence(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int targetIndex = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr.get(mid) == target) {
                targetIndex = mid;
                right = mid - 1;
            } else if (arr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return targetIndex;
    }

    public static int squareRoot(int n) {
        if ( n == 0 ) return 0;
        int left = 1;
        int right = n;
        int res = -1;
        while ( left <= right) {
            int mid = left + (right - left)/2;
            if( mid == n / mid) return mid;
            else if (mid > n/mid) {
                res = mid;
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }
        return res - 1;
    }

    public static int findMinRotated(List<Integer> arr) {
        int left = 0;
        int right = 0;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr.get(mid) <= arr.get(arr.size() -1)) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static int peakOfMountainArray(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr.get(mid) > arr.get(mid + 1)) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static int newspapersSplit(List<Integer> newspaperReadTimes, int numCoworkers){
        int low = Collections.max(newspaperReadTimes);
        int high = 0;
        int ans = -1;
        for (int read_time: newspaperReadTimes) {
            high += read_time;
        }
        while (low <= high) {
            int mid = (low + high) /2;
            if (feasible(newspaperReadTimes, numCoworkers, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean feasible(List<Integer> newspaperReadTimes, int numCoworkers, int limit) {
        int time = 0, numWorkers =0;
        for (int readTime: newspaperReadTimes) {
            if (time + readTime > limit) {
                time = 0;
                numWorkers++;
            }
            time += readTime;
        }
        // edge case to check if we need an extra coworker at the end
        if (time != 0) {
            numWorkers++;
        }
        return numWorkers < numCoworkers;
    }
}