import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.25%)
 * Likes:    368
 * Dislikes: 0
 * Total Accepted:    78K
 * Total Submissions: 180.7K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 判断是否是最接近的
     * 
     * @param closest 当前最接近的
     * @param sum     新的可能符合条件的值
     * @param target  给定的目标值
     * @return 0->可以得到target,1->旧的值更接近,并且比 target 大, -1->旧的值更近,但是比 target 小
     *         2->新的值更近,但是比 target 大 -2->新的值更近,但是比 target 小
     */
    private int isClosest(int closest, int sum, int target) {
        if (sum == target) {
            return 0;
        }
        // 如果之前的 closest 最近
        if (Math.abs(target - closest) <= Math.abs(target - sum)) {
            // 并且 target > sum
            if (target > sum) {
                return -1;
            } else {
                return 1;
            }
            // 如果新的 sum 是最近
        } else {
            if (target > sum) {
                return -2;
            } else {
                return 2;
            }
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        int sum;
        int length = nums.length;
        int left;
        int right;
        int result;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < length; i++) {
            left = i + 1;
            right = length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                // 找到最近的了
                result = isClosest(closest, sum, target);
                if (result == 0) {
                    return target;
                    // 原来的值更接近,并且比 target 小
                }
                if (result == -1) {
                    left++;
                    // 原来的值更接近,并且比 target 大
                } else if (result == 1) {
                    right--;
                } else if (result == -2) {
                    closest = sum;
                    left++;
                } else if (result == 2) {
                    closest = sum;
                    right--;
                }
            }
        }
        return closest;
    }

}
// @lc code=end