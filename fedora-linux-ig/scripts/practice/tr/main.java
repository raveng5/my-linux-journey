import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public static void printst(Stack<Integer> st) {
        while (!st.isEmpty()) {
            System.out.print(st.pop() + "|");
        }
        System.out.println();
    }

    public static void reversearr(int[] arr) {
        int end = arr.length - 1;
        int start = 0;
        int helper;
        while (start < end) {
            helper = arr[start];
            arr[start] = arr[end];
            arr[end] = helper;
            start++;
            end--;
        }
    }

    public static void createStack(Stack<Integer> st, int[] arr) {
        reversearr(arr);
        for (int i = 0; i < arr.length; i++) {
            st.push(arr[i]);
        }
    }

    public static String[] fromstringtoarr(String s) {
        String[] result = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = String.valueOf(s.charAt(i));
        }
        return result;
    }

    public static int food(Stack<Integer> st, Queue<Integer> q) {
        int count = 0;
        int current = 0;
        int checker = 0;
        while (!st.isEmpty()) {
            int len = q.size();
            current = st.pop();
            int x = q.remove();
            if (x == current) {
                count++;
                checker = 0;
            } else {
                q.add(x);
                st.push(current);
                checker++;
            }
            if (checker == len) return count;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 1, 0 };
        int[] arr2 = { 1, 0, 0, 1, 0 };
        //-------------------------------
        Stack<Integer> st = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        //-------------------------------
        createQueue(q, arr);
        createStack(st, arr2);
        System.out.println(food(st, q));
        //printq(q);
        //printst(st);
        //String s = "hii";
        //String[] arr = fromstringtoarr(s);
        //printarr(arr);
    }
}
