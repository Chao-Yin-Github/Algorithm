import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (44.65%)
 * Likes:    344
 * Dislikes: 0
 * Total Accepted:    44.9K
 * Total Submissions: 95.1K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
 * 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 * 
 * 
 * 进阶：
 * 
 * 你能在线性时间复杂度内解决此题吗？
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7] 
 * 解释: 
 * 
 * ⁠ 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int length) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        // todo
        int[] result = new int[nums.length - length + 1];
        int right = 0;
        // Queue<Integer> queue = new PriorityQueue<Integer>((01,02)->{return
        // o2.getIntValue()-o1.getIntValue()});
        Deque<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length - length + 1; i++) {
            while (right < nums.length && right - i < length) {
                if (!list.isEmpty()) {
                    while (!list.isEmpty() && list.getLast() <= nums[right]) {
                        list.removeLast();
                    }
                    list.addLast(nums[right]);
                } else {
                    list.addLast(nums[right]);
                }
                right++;
            }
            result[i] = list.getFirst();
        }
        return result;
    }
}
// @lc code=end
// @lc code=end
