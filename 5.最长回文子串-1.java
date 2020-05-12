/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.30%)
 * Likes:    1078
 * Dislikes: 0
 * Total Accepted:    82.9K
 * Total Submissions: 315K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
class Solution {
    public String longestPalindrome(String s) {
        int start, end;
        start = end = 0;
        int maxLen = 1;
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j < s.length(); j++) {
                if (isHuiWen(i, j, s)) {
                    if (end - start < j - i) {
                        start = i;
                        end = j;
                        maxLen = end - start + 1;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public boolean isHuiWen(int i, int j, String s) {
        for (; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
