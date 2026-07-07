import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

//------THIS IS JUST ME TRANING NOT SOME DEEP-----
public class Main {

    public static void printarr(int[] arr) {
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

    public static boolean bsearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    //--------------------------------------------------------------
    public static void hsort(int[] arr) {
        int n = arr.length;
        //build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //extract elements from heap one by one and place them at the end of the array
        for (int i = n - 1; i > 0; i--) {
            //swap the root (largest element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    //heapify function to maintain the max heap property
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    //-----------------------------------------------------
    public static <K, V> void printMap(HashMap<K, V> map) {
        if (map.isEmpty()) {
            System.out.println("The map is empty.");
            return;
        }

        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(
                "Key: " + entry.getKey() + " | Value: " + entry.getValue()
            );
        }
    }

    public static HashMap<Integer, Integer> arrayToHashMap(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return freqMap;
    }

    public static int major(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        if (map.containsValue(arr.length / 2 + 1)) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > arr.length / 2) {
                    return entry.getKey();
                }
            }
        }
        return -1;
    }

    public static int[] tsum(int[] arr, int target) {
        int[] result = { -1, -2 };
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (
                map.containsKey(target - arr[i]) &&
                map.get(target - arr[i]) != i
            ) {
                result[0] = i;
                result[1] = map.get(target - arr[i]);
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //HashMap<String, Integer> map = new HashMap<>();
        //int[] arr = { 4, 2, 4, 5, 3, 4, 3, 4, 4, 1, 7, 4, 4 };
        //System.out.println(major(arr));
        int[] arr2 = { 1, 7, 0, 1, 5, 2 };
        //-------------------------------
        //Stack<Integer> st = new Stack<>();
        //Queue<Integer> q = new LinkedList<>();
        //-------------------------------
        //createQueue(q, arr);
        //createStack(st, arr2);
        //System.out.println(food(st, q));
        //printq(q);
        //printst(st);
        //String s = "hii";
        //String[] arr = fromstringtoarr(s);
        //printarr(arr);
        //System.out.println(bsearch(arr, 6));
        //System.out.println("Original array:");
        //printarr(arr);

        //hsort(arr);

        //System.out.println("Sorted array:");
        //printarr(arr);
        printarr(tsum(arr2, 9));
    }
}
