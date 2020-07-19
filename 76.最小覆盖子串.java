import java.util.*;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 *
 * algorithms Hard (36.35%) Likes: 381 Dislikes: 0 Total Accepted: 28.4K Total
 * Submissions: 79.9K Testcase Example: '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC"
 * 
 * 说明：
 * 
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> data = new HashMap<>();
        // 遍历字符串 t，初始化每个字母的次数
        for (int i = 0; i < t.length(); i++) {
            char char_i = t.charAt(i);
            data.put(char_i, data.getOrDefault(char_i, 0) + 1);
        }
        int left = 0; // 左指针
        int right = 0; // 右指针
        int start = 0; // 保存最小窗口的左边界
        int end = -1; // 保存最小窗口的右边界
        int min = Integer.MAX_VALUE; // 当前最小窗口的长度
        // 遍历字符串 s
        while (right < s.length()) {
            char char_right = s.charAt(right);
            if (data.containsKey(char_right)) {
                data.put(char_right, data.get(char_right) - 1);
                while (match(data)) {
                    int len = right - left + 1;
                    if (len < min) {
                        start = left;
                        end = right;
                        min = len;
                    }
                    char leftChar = s.charAt(left);
                    if (data.containsKey(leftChar)) {
                        data.put(leftChar, data.get(leftChar) + 1);
                    }
                    left++;
                }
            }
            right++;
        }
        return s.substring(start, end + 1);
    }

    private boolean match(Map<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
