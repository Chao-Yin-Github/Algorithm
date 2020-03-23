/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 * 
 * started at 2020-03-21 21:37:14
 * 
 * finished at 2020-03-21 21:53:28
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (40.49%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    88K
 * Total Submissions: 205.1K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int left, right;
        left = 0;
        right = s.length() - 1;
        char[] array = s.toUpperCase().toCharArray();
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(array[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(array[right])) {
                right--;
            }
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end
