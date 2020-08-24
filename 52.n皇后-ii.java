/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 *
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (79.30%)
 * Likes:    141
 * Dislikes: 0
 * Total Accepted:    30.3K
 * Total Submissions: 38.2K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或
 * N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 * 
 * 
 */

// @lc code=start
class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        dfs(0, 0, 0, 0, n);
        return count;
    }

    /**
     * @param ld  左下方
     * @param rd  右下方
     * @param row 当前行数
     * @param col 当前列数
     * @param n   总的行/列数
     */
    private void dfs(int ld, int rd, int row, int col, int n) {
        if (row == n) {
            count++;
        }
        /**
         * bit 代表可以用的位，例如 0010 代表第 3列可以用
         * 
         * ～(ld | col | rd)：把这些数中为1的位统计起来，代表是已经使用过的，再取反，此时得到为1的位，就是可以使用的位
         * 
         * (1<<n)-1: 得到n个1
         * 
         * 上面两个相与，把高位清零，得到可以使用的位(用1表示)
         */
        int bit = ~(ld | col | rd) & ((1 << n) - 1);
        while (bit > 0) {
            // 从低位得到为1的位，例如 111110 会变为 000010
            // 这样表示要放到哪个位置，行列信息都保留下来了
            int tryBit = bit & -bit;
            /**
             * col | tryBit 是将选择的列的信息保存下来，为1的位表示已经使用过 ld | tryBit
             * 同理，只不过这是为了保证反对角线上不重复，所以还要右移一位 (rd | tryBit) 同上，而由于是正对角线，所以这里是左移
             */
            dfs(((ld | tryBit) << 1), ((rd | tryBit) >> 1), row + 1, col | tryBit, n);
            // 把低位为1的清除，相当于撤销选择
            bit = bit & (bit - 1);
        }
    }
}
// @lc code=end
