/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 *
 * started at 2020-03-09 20:49:37
 * 
 * accomplished at 2020-03-09 21:15:26
 * 
 * 题解:通过理解"原地"一词,在加上"数组的顺序可以改变"这句话,我就知道需要双指针
 * 
 * perception: By understanding the word "in-place" add the phrase "The order of the element of array can be changed.",
 * I knew that two pointers were needed.
 * 
 * 思想:两个指针分别从左边和右边往另一端移动,如果左边的指针的值是目标元素,那么把右指针指向的值给左指针,长度减减;
 * 如果右指针也是目标元素,那么将右指针向左移动,同时长度减减,直到找到一个不为 target 的值或者 left<right
 * 如果 left+1==right,说明下一次不会进入大循环,length 会多算一个,所以此处要特判.
 * 
 * https://leetcode-cn.com/problems/remove-element/description/
 * 
 * algorithms
 * Easy (55.45%)
 * Likes:    495
 * Dislikes: 0
 * Total Accepted:    146.1K
 * Total Submissions: 253.2K
 * Testcase Example:  '[3,2,2,3]\n3'
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 给定 nums = [3,2,2,3], val = 3,
 * 
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 示例 2:
 * 
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 
 * 注意这五个元素可为任意顺序。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 
 * 你可以想象内部操作如下:
 * 
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * 
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 * 
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int target) {
        int length = nums.length;
        if (length == 1) {
            if (nums[0] == target) {
                length--;
            }
        }
        int left = 0;
        int right = length - 1;
        // 思想:两个指针分别从左边和右边往另一端移动,如果左边的指针的值是目标元素,那么把右指针指向的值给左指针;
        while (left < right) {
            if (nums[left] == target) {
                length--;
                // 如果右指针也是目标元素,那么将右指针向左移动,直到找到一个不为 target 的值或者 left<right
                while (left < right && nums[right] == target) {
                    right--;
                    length--;
                }
                if (left < right) {
                    nums[left] = nums[right];
                    right--;
                }
            }
            // 如果 left+1==right,说明下一次不会进入大循环,length 会多算一个,所以此处要特判.
            if (left + 1 == right) {
                if (nums[right] == target) {
                    length--;
                }
            }
            left++;
        }
        return length;
    }
}
// @lc code=end
