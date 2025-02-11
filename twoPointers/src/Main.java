import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static int removeDuplicates(List<Integer> arr) {
        int slow = 0;
        for (int fast =0; fast < arr.size(); fast++) {
            if (arr.get(fast) != arr.get(slow)) {
                slow++;
                arr.set(slow, arr.get(fast));
            }
        }
        return slow + 1;
    }
}