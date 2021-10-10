
import java.util.*;

class Solution {

}
// @lc code=end

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 5, 2, 1, 5 };
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < nums.length) {
            if (set.contains(nums[right])) {
                set.remove(nums[left]);
                left++;
            } else {
                set.add(nums[right]);
                right++;
                sum = Math.max(sum, set.stream().mapToInt(Integer::intValue).sum());
            }
        }
        System.out.println(sum);
    }
}