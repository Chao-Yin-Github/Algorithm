import java.util.*;
/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (46.12%)
 * Likes:    270
 * Dislikes: 0
 * Total Accepted:    43.2K
 * Total Submissions: 92.4K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        helper(list, "", s, 3, -1);
        return list;
    }

    private void helper(List<String> list, String str, String s, int dots, int currentPos) {
        if (dots == 0) {
            list.add(str);
        }
        int maxPos = Math.min(s.length() - 1, currentPos + 4);
        for (int i = currentPos + 1; i < maxPos; i++) {
            String string = s.substring(currentPos + 1, i + 1);
            if (canPlace(str)) {
                if (dots != 1) {
                    helper(list, str + string + ".", s, dots - 1, i);
                    return;
                } else {
                    helper(list, str + string, s, dots - 1, i);
                }
            }
        }
    }

    private boolean canPlace(String s) {
        if (s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0') || Integer.valueOf(s) > 255) {
            return false;
        } else {
            return true;
        }
    }
}
// @lc code=end
