import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms Easy (60.41%) Likes: 145 Dislikes: 0 Total Accepted: 51.3K Total
 * Submissions: 84.1K Testcase Example: '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        Integer[] dp = new Integer[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            dp[i] = 1;
            for (int j = i; j > 1; j--) {
                dp[j - 1] = dp[j - 1] + dp[j - 2];
            }
        }
        return new ArrayList<Integer>(Arrays.asList(dp));
    }
}
// @lc code=end
