/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 *
 * https://leetcode-cn.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (42.20%)
 * Likes:    360
 * Dislikes: 0
 * Total Accepted:    69K
 * Total Submissions: 163.5K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * 
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * 运行你的函数后，矩阵变为：
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * 
 * 解释:
 * 
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O'
 * 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) {
            return;
        }
        int col = board[0].length;
        // 将左和右边界上的 O 换成 -
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                changeToHorizontal(board, i, 0, row, col);
            }
            if (board[i][col - 1] == 'O') {
                changeToHorizontal(board, i, col - 1, row, col);
            }
        }
        // 将上和下边界上的 O 换成 -
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                changeToHorizontal(board, 0, i, row, col);
            }
            if (board[row - 1][i] == 'O') {
                changeToHorizontal(board, row - 1, i, row, col);
            }
        }
        // for (int i = 0; i < row; i++) {
        // for (int j = 0; j < col; j++) {
        // System.out.print(board[i][j] + " ");
        // }
        // System.out.println();
        // }
        // 第二次遍历，将所有 'O' 变成 'X'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void changeToHorizontal(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        if (board[i][j] == 'X' || board[i][j] == '-') {
            return;
        }
        board[i][j] = '-';
        changeToHorizontal(board, i, j + 1, row, col);
        changeToHorizontal(board, i, j - 1, row, col);
        changeToHorizontal(board, i + 1, j, row, col);
        changeToHorizontal(board, i - 1, j, row, col);
    }
}
// @lc code=end
