import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * algorithms
 * Medium (43.93%)
 * Likes:    350
 * Dislikes: 0
 * Total Accepted:    45.4K
 * Total Submissions: 103.4K
 * Testcase Example:  '"PAYPALISHIRING"\n3'
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 
 * 
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 请你实现这个将字符串进行指定行数变换的函数：
 * 
 * string convert(string s, int numRows);
 * 
 * 示例 1:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * 
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 
 */
class Solution {
    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> arrayList = new ArrayList<StringBuilder>();
        if (numRows == 1)
            return s;
        for (int i = 0; i < (s.length() > numRows ? s.length() : numRows); i++) {
            arrayList.add(new StringBuilder());
        }
        boolean isDown = false;
        int currow = 0;
        for (char c : s.toCharArray()) {
            arrayList.get(currow).append(c);
            if (currow == 0 || currow == numRows - 1)
                isDown = !isDown;
            currow += isDown ? 1 : -1;
        }
        StringBuilder string = new StringBuilder();
        for (StringBuilder str : arrayList) {
            string.append(str);
        }
        return string.toString();
    }
}
