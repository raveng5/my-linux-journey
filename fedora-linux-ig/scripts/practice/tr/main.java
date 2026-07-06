import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static <T> void printarr(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }

    public static void printq(Queue<Integer> q) {
        q.add(null);
        while (q.peek() != null) {
            int x = q.remove();
            System.out.print(x + "|");
            q.add(x);
        }
        q.remove();
    }

    public static void createQueue(Queue<Integer> q, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }
    }

    public static String[] fromstringtoarr(String s) {
        String[] result = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = String.valueOf(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] arr = { 1, 2, 3, 4, 5 };
        //-------------------------------
        //Queue<Integer> q = new LinkedList<>();
        //createQueue(q, arr);
        //printq(q);
        String s = "hii";
        String[] arr = fromstringtoarr(s);
        printarr(arr);
    }
}
