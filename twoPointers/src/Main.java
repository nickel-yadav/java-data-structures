import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this(val, null);
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int removeDuplicates(List<Integer> arr) {
        int slow = 0;
        for (int fast =0; fast < arr.size(); fast++) {
            if (!Objects.equals(arr.get(fast), arr.get(slow))) {
                slow++;
                arr.set(slow, arr.get(fast));
            }
        }
        return slow + 1;
    }

    public static int middleOfLinkedList(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public static void moveZeros(List<Integer> nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.size(); fast++) {
            int slowNum = nums.get(slow);
            nums.set(slow, nums.get(fast));
            nums.set(fast, slowNum);
            slow++;
        }
    }

    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int l =0;
        int r = arr.size() - 1;
        while (l < r) {
            int twoSum = arr.get(l) + arr.get(r);
            if (twoSum == target) {
                return List.of(l,r);
            }
            else if (twoSum < target) {
                l++;
            }
            else {
                r--;
            }
        }
        return null;
    }

    public static boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while ( l < r ) {
            while (l < r && !Character.isLetterOrDigit(arr[l])) {
                l++;
            }
            while ( l < r && !Character.isLetterOrDigit(arr[r])){
                r--;
            }
            if (Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r])) return false;
            l++;
            r--;
        }
        return true;
    }
}