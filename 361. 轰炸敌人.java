/**
 * Lintcode: https://www.lintcode.com/problem/bomb-enemy/my-submissions
 * Leetcode: 361 已锁定
 * 
 * 给定一个二维矩阵, 每一个格子可能是一堵墙 W,或者 一个敌人 E 或者空 0 (数字 '0'), 返回你可以用一个炸弹杀死的最大敌人数.
 * 炸弹会杀死所有在同一行和同一列没有墙阻隔的敌人。 由于墙比较坚固，所以墙不会被摧毁. 样例 样例1
 *
 * 输入: grid =[ "0E00", "E0WE", "0E00" ] 输出: 3 解释: 把炸弹放在 (1,1) 能杀3个敌人 样例2
 *
 * 输入: grid =[ "0E00", "EEWE", "0E00" ] 输出: 2 解释: P把炸弹放在 (0,0) 或 (0,3) 或 (2,0) 或
 * (2,3) 能杀2个敌人 注意事项 你只能在空的地方放置炸弹.
 */
public class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] up = new int[row][col];
        int[][] left = new int[row][col];
        int[][] down = new int[row][col];
        int[][] right = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'w') {
                    up[i][j] = 0;
                } else if (grid[i][j] == 'E') {
                    if (i > 0) {
                        up[i][j] = up[i - 1][j] + 1;
                    } else {
                        up[0][j] = 1;
                    }
                } else {
                    if (grid[i][j] == '0') {
                        if (i == 0) {
                            up[0][j] = 0;
                        } else {
                            up[i][j] = up[i - 1][j];
                        }
                    }
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                } else if (grid[i][j] == 'E') {
                    if (i == row - 1) {
                        down[i][j] = 1;
                    } else {
                        down[i][j] = down[i + 1][j] + 1;
                    }
                } else {
                    if (i == row - 1) {
                        down[i][j] = 0;
                    } else {
                        down[i][j] = down[i + 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[j][i] == 'W') {
                    left[j][i] = 0;
                } else if (grid[j][i] == 'E') {
                    if (i == 0) {
                        left[j][i] = 1;
                    } else {
                        left[j][i] = left[j][i - 1] + 1;
                    }
                } else {
                    if (i == 0) {
                        left[j][i] = 0;
                    } else {
                        left[j][i] = left[j][i - 1];
                    }
                }
            }
        }
        for (int i = col - 1; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                if (grid[j][i] == 'W') {
                    right[j][i] = 0;
                } else if (grid[j][i] == 'E') {
                    if (i == col - 1) {
                        right[j][i] = 1;
                    } else {
                        right[j][i] = right[j][i + 1] + 1;
                    }
                } else {
                    if (i == col - 1) {
                        right[j][i] = 0;
                    } else {
                        right[j][i] = right[j][i + 1];
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    max = Math.max(max, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}