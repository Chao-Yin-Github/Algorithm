import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        if (row == 0) {
            return 0;
        }
        int col = heights[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        // 不断更新 dp 数组的值，知道里面的值全部稳定为止
        while (true) {
            boolean flag = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int temp = dp[i][j];
                    if (i + 1 < row) {
                        dp[i][j] = Math.min(dp[i][j],
                                Math.max(dp[i + 1][j], Math.abs(heights[i][j] - heights[i + 1][j])));
                    }
                    if (i - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j],
                                Math.max(dp[i - 1][j], Math.abs(heights[i][j] - heights[i - 1][j])));
                    }
                    if (j + 1 < col) {
                        dp[i][j] = Math.min(dp[i][j],
                                Math.max(dp[i][j + 1], Math.abs(heights[i][j] - heights[i][j + 1])));
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] = Math.min(dp[i][j],
                                Math.max(dp[i][j - 1], Math.abs(heights[i][j] - heights[i][j - 1])));
                    }
                    if (temp != dp[i][j]) {
                        flag = true;
                    }
                }
            }
            if (!flag) {
                break;
            }
        }
        return dp[row - 1][col - 1];
    }
}