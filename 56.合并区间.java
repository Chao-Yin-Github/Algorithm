import java.util.*;
/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (37.53%)
 * Likes:    249
 * Dislikes: 0
 * Total Accepted:    44.5K
 * Total Submissions: 112.4K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {};
        }
        Arrays.sort(intervals, (v1, v2) -> {
            return v1[0] - v2[0];
        });
        int[][] res = new int[intervals.length][2];
        int p = 0;
        res[p][0] = intervals[0][0];
        res[p][1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (res[p][1] >= intervals[i][0]) {
                if (res[p][1] < intervals[i][1]) {
                    res[p][1] = intervals[i][1];
                }
            } else {
                res[++p][0] = intervals[i][0];
                res[p][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(res, p + 1);
    }
}
// @lc code=end
