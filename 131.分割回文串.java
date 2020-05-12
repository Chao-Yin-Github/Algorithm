import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (66.27%)
 * Likes:    277
 * Dislikes: 0
 * Total Accepted:    31K
 * Total Submissions: 46K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return lists;
        }

        // judge[i][j] 表示从 i 到 j 是否为回文串
        boolean[][] judge = new boolean[s.length() + 1][s.length() + 1];
        // 先得到是否为回文串的表
        int left, right, center;
        // 奇数
        for (center = 0; center < s.length(); center++) {
            left = center;
            right = center;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                judge[left][right] = true;
                left--;
                right++;
            }
        }
        // 偶数
        for (center = 0; center < s.length(); center++) {
            left = center;
            right = center + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                judge[left][right] = true;
                left--;
                right++;
            }
        }

        back(s, 0, lists, new ArrayList<String>(), judge);
        return lists;
    }

    private void back(String s, int start, List<List<String>> lists, List<String> path, boolean[][] judge) {
        if (start == s.length()) {
            lists.add(new ArrayList<>(path));
        }
        for (int i = start; i < s.length(); i++) {
            if (judge[start][i]) {
                path.add(s.substring(start, i + 1));
                back(s, i + 1, lists, path, judge);
                path.remove(path.size() - 1);
            }
        }
    }
}
// @lc code=end
