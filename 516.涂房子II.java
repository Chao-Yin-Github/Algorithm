/**
 * 中文English
 * 这里有n个房子在一列直线上，现在我们需要给房屋染色，共有k种颜色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。
 * 
 * 费用通过一个nxk 的矩阵给出，比如cost[0][0]表示房屋0染颜色0的费用，cost[1][2]表示房屋1染颜色2的费用。
 * 
 * 样例 样例1
 * 
 * 输入: costs = [[14,2,11],[11,14,5],[14,3,10]] 输出: 10 说明:
 * 三个屋子分别使用第1,2,1种颜色，总花费是10。 样例2
 * 
 * 输入: costs = [[5]] 输出: 5 说明： 只有一种颜色，一个房子，花费为5 挑战 用O(nk)的时间复杂度解决
 * 
 * 注意事项 所有费用都是正整数
 */
public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int number = costs.length;
        int kind = costs[0].length;
        if (kind == 0) {
            return 0;
        }
        // dp[i][j] 表示前 i-1 个房子使用 j 涂色的最小花费
        int[][] dp = new int[number + 1][kind];
        // 前 i-i 个房子的最小花费 : dp[i-1]这一行的最小值
        int min;
        int mini = 0;
        // 前 i-i 个房子的次小花费 : dp[i-1]这一行的次小值
        int second;
        int secondi = 0;
        for (int i = 1; i <= number; i++) {
            // 得到涂不同颜色的最小值和次小值
            min = second = Integer.MAX_VALUE;
            // 直接根据min 和 second 计算最小值
            for (int j = 0; j < kind; j++) {
                if (dp[i - 1][j] < min) {
                    second = min;
                    min = dp[i - 1][j];
                    secondi = mini;
                    mini = j;
                } else if (dp[i - 1][j] < second) {
                    second = dp[i - 1][j];
                    secondi = j;
                }
            }
            for (int j = 0; j < kind; j++) {
                dp[i][j] = costs[i - 1][j];
                if (j != mini) {
                    dp[i][j] += min;
                } else {
                    dp[i][j] += second;
                }
            }
        }
        min = Integer.MAX_VALUE;
        for (int i = 0; i < kind; i++) {
            min = Math.min(min, dp[number][i]);
        }
        return min;
    }
}