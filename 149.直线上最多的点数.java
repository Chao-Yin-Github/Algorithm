import java.util.*;
/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 *
 * https://leetcode-cn.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (23.16%)
 * Likes:    195
 * Dislikes: 0
 * Total Accepted:    17.4K
 * Total Submissions: 74.7K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 
 * 示例 1:
 * 
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length <= 1) {
            return 0;
        }
        int length = points.length;
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                double rate = (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                map.put(rate, map.getOrDefault(rate, 0) + 1);
            }
        }
        return map.values().stream().mapToInt(item -> item.intValue()).max().orElse(0);
    }
}
// @lc code=end
