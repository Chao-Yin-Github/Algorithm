import java.util.*;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (73.63%)
 * Likes:    813
 * Dislikes: 0
 * Total Accepted:    88.3K
 * Total Submissions: 119.9K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        helper(list, n, n, new StringBuilder());
        return list;
    }

    private void helper(List<String> list, int left, int right, StringBuilder str) {
        if (left == 0 && right == 0) {
            list.add(str.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            helper(list, left - 1, right, str.append('('));
            str.deleteCharAt(str.length() - 1);
        }
        if (right > 0) {
            helper(list, left, right - 1, str.append(')'));
            str.deleteCharAt(str.length() - 1);
        }
    }
}
// @lc code=end
