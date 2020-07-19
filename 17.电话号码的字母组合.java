import java.util.*;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (50.21%)
 * Likes:    602
 * Dislikes: 0
 * Total Accepted:    83.7K
 * Total Submissions: 158.6K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {
    String[] letter = { " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        dfs(digits.toCharArray(), new StringBuilder(), list, 0);
        return list;
    }

    private void dfs(char[] arr, StringBuilder str, List<String> list, int level) {
        if (level == arr.length) {
            list.add(str.toString());
            return;
        }
        String string = letter[arr[level] - '0'];
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            str.append(chars[i]);
            dfs(arr, str, list, level + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
// @lc code=end
