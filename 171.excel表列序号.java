/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-number/description/
 *
 * algorithms
 * Easy (66.87%)
 * Likes:    136
 * Dislikes: 0
 * Total Accepted:    39.2K
 * Total Submissions: 58.3K
 * Testcase Example:  '"A"'
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 
 * 例如，
 * 
 * ⁠   A -> 1
 * ⁠   B -> 2
 * ⁠   C -> 3
 * ⁠   ...
 * ⁠   Z -> 26
 * ⁠   AA -> 27
 * ⁠   AB -> 28 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: "A"
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: "AB"
 * 输出: 28
 * 
 * 
 * 示例 3:
 * 
 * 输入: "ZY"
 * 输出: 701
 * 
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 * 
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int base = arr[i] - 'A' + 1;
            sum += base * Math.pow(26, arr.length - i - 1);
        }
        return sum;
    }
}
// @lc code=end
