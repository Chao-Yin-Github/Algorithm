/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 *
 * https://leetcode-cn.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (37.16%)
 * Likes:    117
 * Dislikes: 0
 * Total Accepted:    8.1K
 * Total Submissions: 21.4K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * 
 */

// @lc code=start
class Solution {

    int[][] memo = null;

    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new int[s1.length()][s2.length()];
        return back(s1, 0, s2, 0, s3, 0);
    }

    private boolean back(String s1, int i, String s2, int j, String s3, int k) {
        if (i > s1.length() || j > s2.length() || k > s3.length()) {
            return false;
        }
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] != 0) {
            return memo[i][j] == 1 ? true : false;
        }
        if (s1.charAt(i) == s3.charAt(k)) {
            if (back(s1, i + 1, s2, j, s3, k + 1)) {
                memo[i][j] = 1;
            } else {
                memo[i][j] = -1;
            }
        }
        if (s2.charAt(j) == s3.charAt(k)) {
            if (back(s1, i, s2, j + 1, s3, k + 1)) {
                memo[i][j] = 1;
            } else {
                if (memo[i][j] != 0) {
                    memo[i][j] = -1;
                }
            }
        }
        return memo[i][j] == 0 ? false : (memo[i][j] == 1 ? true : false);
    }
}

// @lc code=end
