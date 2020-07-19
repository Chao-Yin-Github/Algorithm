import java.util.*;

public class Mex {
    public int getMex(int[] A, int n) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            Integer value = map.get(A[i - 1]);
            if (value == null) {
                map.put(A[i - 1], 1);
            }
        }
        map.forEach((key, value) -> {
            System.out.print(key + " " + value + "\n");
        });
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (map.get(i) == null) {
                return i;
            } else {
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Mex mex = new Mex();
        System.out.println(mex.getMex(new int[] { 1, 2, 3, 5, 6, 3, 2 }, 7));
    }
}