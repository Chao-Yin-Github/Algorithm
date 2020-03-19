/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 * 
 * started at 2020-03-19 21:04:27 
 * 
 * finished at 2020-03-19 21:45:30
 * 
 * tips : 思想和 之前的 删除数组I 类似,不过有一个很重要的点:
 * 
 * 因为是最多两个相同,那么使用快慢指针时需要注意:
 *
 * 无论是哪种情况(是否需要删除) first +1 和 first +2 每次都要赋值,以此更新得到正确的数组
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * algorithms
 * Medium (51.10%)
 * Likes:    195
 * Dislikes: 0
 * Total Accepted:    36.2K
 * Total Submissions: 66.2K
 * Testcase Example:  '[1,1,1,2,2,3]'
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 
 * 示例 1:
 * 
 * 给定 nums = [1,1,1,2,2,3],
 * 
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 示例 2:
 * 
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 
 * 你不需要考虑数组中超出新长度后面的元素。
 * 
 * 
 * 说明:
 * 
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 
 * 你可以想象内部操作如下:
 * 
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * 
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * 
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int first, second;
        first = 0;
        second = 1;
        int length = nums.length;
        while (second < length) {
            if (nums[first] == nums[second]) {
                while (second < length && nums[first] == nums[second]) {
                    second++;
                }
                // 优化了对于出现次数的判断,之前写的时候发现 if 和 else 里代码都一样
                // 因为不管是不是出现了两次,要不要删除, first+1 和 first+2 的赋值都需要改变
                if (second < length) {
                    nums[first + 2] = nums[second];
                    nums[first + 1] = nums[first];
                    first += 2;
                    second++;
                    // 如果后面的值一直都相等,导致second=length,循环终止
                } else {
                    nums[first + 1] = nums[first];
                    first++;
                }
                // 出现两个连续不一样的,不需要删除,但是需要更新赋值
            } else {
                nums[first + 1] = nums[second];
                first++;
                second++;
            }
        }
        // first 代表下表,此处要加一
        return first + 1;
    }
}
// @lc code=end
