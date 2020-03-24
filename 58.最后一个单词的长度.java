/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * started at 2020-03-24 16:56:13
 * 
 * finished at 2020-03-24 17:07:37
 * 
 * perception：meaningless
 * 
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (32.80%)
 * Likes:    182
 * Dislikes: 0
 * Total Accepted:    76.9K
 * Total Submissions: 234.5K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        if (i != s.length() - 1) {
            return s.length() - 1 - i;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        int j = i;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return j - i;
    }
}
// @lc code=end
