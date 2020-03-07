import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.35%)
 * Likes:    1861
 * Dislikes: 0
 * Total Accepted:    166.3K
 * Total Submissions: 646.1K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 
 * 
 * 示例：
 * 
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int length = nums.length;
        int sum;
        ArrayList<Integer> list = null;
        for (int i = 0; i < length; i++) {
            // 最小的都大于0,之后的都不可能找到
            if (nums[i] > 0) {
                break;
            }
            // 如果这个和上一个一样,那么会重复,直接找下一个
            // attention: 注意是上一个值而不是下一个,因为上一个 i-1 所代表的取值范围一定大于这一个 i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list = new ArrayList<>(3);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }
}
// @lc code=end
