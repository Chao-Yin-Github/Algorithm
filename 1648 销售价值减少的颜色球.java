import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://leetcode-cn.com/problems/sell-diminishing-valued-colored-balls/
// @lc code=start
class Solution {
    private final int MOD = 10_0000_0007;

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int left = 0;
        int right = inventory[inventory.length - 1];
        long result1, result2;
        result1 = result2 = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            result1 = Arrays.stream(inventory).filter(item -> item >= mid).mapToLong(item -> (long) item).reduce(0L,
                    (acc, item) -> {
                        acc += item - mid;
                        return acc;
                    });
            // System.out.println(result1);
            if (result1 <= orders) {
                // result 1 一定比 result2 大，而且他俩都随 mid 增加而递增
                result2 = Arrays.stream(inventory).filter(item -> item >= mid).mapToLong(item -> (long) item).reduce(0L,
                        (acc, item) -> {
                            acc += item - mid + 1;
                            return acc;
                        });
                // System.out.println(result2);
                if (result2 >= orders) {
                    break;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        int mid = left + ((right - left) >> 1);
        long countPart = orders - result1;
        // System.out.println(mid + " " + countPart + " " + result1);
        long result = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] >= mid) {
                if (countPart > 0) {
                    result = (result + countSum(mid, inventory[i], inventory[i] - mid + 1));
                    countPart--;
                } else {
                    result = (result + countSum(mid + 1, inventory[i], inventory[i] - mid));
                }
            }
        }
        return (int) (result % MOD);
    }

    private long countSum(int a1, int an, int n) {
        long a = 1L * (a1 + an);
        long result = (a * n) / 2;
        // System.out.println(a1 + "," + an + "," + n + ":" + result);
        return result;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] inventory = stringToIntegerArray(line);
            line = in.readLine();
            int orders = Integer.parseInt(line);

            int ret = new Solution().maxProfit(inventory, orders);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}