/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 * 
 * started at 2020-03-24 15:13:52
 * 
 * finished at 2020-03-24 15:50:14
 * 
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (36.62%)
 * Likes:    921
 * Dislikes: 0
 * Total Accepted:    211.3K
 * Total Submissions: 576.6K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return divideAndConquer(strs, 0, strs.length - 1);
    }

    /**
     * @return 得到 strs 数组的从 left 到 right 的所有字符串的最大公共前缀
     */
    private String divideAndConquer(String[] strs, int left, int right) {
        if (left == right) {
            return strs[right];
        }
        int mid = (left + right) / 2;
        String leftHalf = divideAndConquer(strs, left, mid);
        String rightHalf = divideAndConquer(strs, mid + 1, right);
        return countCommonPrefix(leftHalf, rightHalf);
    }

    /**
     * @param firstString
     * @param secondString
     * @return 找出两个字串的最大公共前缀
     */
    private String countCommonPrefix(String firstString, String secondString) {
        int min = Math.min(firstString.length(), secondString.length());
        for (int i = 0; i < min; i++) {
            if (firstString.charAt(i) != secondString.charAt(i)) {
                min = i;
            }
        }
        return firstString.substring(0, min);
    }
}