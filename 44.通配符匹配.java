/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 *
 * https://leetcode-cn.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (31.24%)
 * Likes:    532
 * Dislikes: 0
 * Total Accepted:    54.6K
 * Total Submissions: 173.8K
 * Testcase Example:  '"aa"\n"a"'
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * 
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 
 * 
 * 两个字符串完全匹配才算匹配成功。
 * 
 * 说明:
 * 
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 
 * 示例 2:
 * 
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 
 * 
 * 示例 4:
 * 
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 
 * 
 * 示例 5:
 * 
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 * 
 */
// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, p);
    }

    public boolean dfs(String s, String p) {
        System.out.println(s + "\n" + p);
        if (s == null || s.trim().length() == 0) {
            if (p == null || p.trim().length() == 0) {
                return true;
            }
            char[] chars = p.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] >= 'a' && chars[i] <= 'z') || chars[i] == '?') {
                    return false;
                }
            }
            return true;
        }
        int p1 = 0;
        int p2 = 0;
        char[] chars1 = s.toCharArray();
        char[] chars2 = p.toCharArray();
        int len1 = s.length();
        int len2 = p.length();
        while (p1 < len1 && p2 < len2) {
            char char1 = chars1[p1];
            char char2 = chars2[p2];
            if (char2 == '*') {
                // 消去多个连续的 *
                while (p2 < len2 - 1 && char2 == '*') {
                    char2 = chars2[++p2];
                }
                if (p2 == len2 - 1 && char2 == '*') {
                    return true;
                }
                if (char2 == '?') {
                    int tempIndex = p1;
                    while (!dfs(s.substring(tempIndex), p.substring(p2))) {
                        if (tempIndex < len1) {
                            tempIndex++;
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
                // 如果递归条件为 false
                while (!dfs(s.substring(p1), p.substring(p2))) {
                    // 更新 p1 的值
                    p1 = s.indexOf(char2, p1 + 1);
                    // 如果没有了，那么不匹配
                    // 如果还有，那么就继续向后找
                    if (p1 == -1) {
                        return false;
                    }
                }
                return true;
            } else if (char2 == '?') {
                p1++;
                p2++;
            } else {
                if (char1 != char2) {
                    return false;
                }
                p1++;
                p2++;
            }
        }
        if (len1 != p1)

        {
            return false;
        }
        if (p2 == len2) {
            return true;
        } else {
            return dfs("", p.substring(p2));
        }
    }
}
// @lc code=end

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String p = stringToString(line);

            boolean ret = new Solution().isMatch(s, p);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, p);
    }

    public boolean dfs(String s, String p) {
        System.out.println(s + "\n" + p);
        if (s == null || s.trim().length() == 0) {
            if (p == null || p.trim().length() == 0) {
                return true;
            }
            char[] chars = p.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ((chars[i] >= 'a' && chars[i] <= 'z') || chars[i] == '?') {
                    return false;
                }
            }
            return true;
        }
        int p1 = 0;
        int p2 = 0;
        char[] chars1 = s.toCharArray();
        char[] chars2 = p.toCharArray();
        int len1 = s.length();
        int len2 = p.length();
        while (p1 < len1 && p2 < len2) {
            char char1 = chars1[p1];
            char char2 = chars2[p2];
            if (char2 == '*') {
                // 消去多个连续的 *
                while (p2 < len2 - 1 && char2 == '*') {
                    char2 = chars2[++p2];
                }
                if (p2 == len2 - 1 && char2 == '*') {
                    return true;
                }
                if (char2 == '?') {
                    int tempIndex = p1;
                    while (!dfs(s.substring(tempIndex), p.substring(p2))) {
                        if (tempIndex < len1) {
                            tempIndex++;
                        }
                        return false;
                    }
                    return true;
                }
                // 如果递归条件为 false
                while (!dfs(s.substring(p1), p.substring(p2))) {
                    // 更新 p1 的值
                    p1 = s.indexOf(char2, p1 + 1);
                    // 如果没有了，那么不匹配
                    // 如果还有，那么就继续向后找
                    if (p1 == -1) {
                        return false;
                    }
                }
                return true;
            } else if (char2 == '?') {
                p1++;
                p2++;
            } else {
                if (char1 != char2) {
                    return false;
                }
                p1++;
                p2++;
            }
        }
        if (len1 != p1) {
            return false;
        }
        if (p2 == len2) {
            return true;
        } else {
            return dfs("", p.substring(p2));
        }
    }
}
// @lc code=end
