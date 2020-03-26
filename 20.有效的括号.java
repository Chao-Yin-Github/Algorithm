import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 * 
 * started at 2020-03-24 14:50:53
 * 
 * finished at 2020-03-24 15:02:36
 * 
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (41.18%)
 * Likes:    1453
 * Dislikes: 0
 * Total Accepted:    233.5K
 * Total Submissions: 566.7K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> left_stack = new Stack<>();
        char current;
        char target;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                left_stack.push(current);
            } else {
                if (left_stack.isEmpty()) {
                    return false;
                }
                target = left_stack.pop();
                if (current == ')') {
                    if (target != '(') {
                        return false;
                    }
                } else if (current == ']') {
                    if (target != '[') {
                        return false;
                    }
                } else {
                    if (target != '{') {
                        return false;
                    }
                }
            }
        }
        if (left_stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end
