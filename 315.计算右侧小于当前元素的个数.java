import java.util.*;

/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 *
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 * description/
 *
 * algorithms Hard (41.46%) Likes: 452 Dislikes: 0 Total Accepted: 36K Total
 * Submissions: 86.7K Testcase Example: '[5,2,6,1]'
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于
 * nums[i] 的元素的数量。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：nums = [5,2,6,1] 输出：[2,1,1,0] 解释： 5 的右侧有 2 个更小的元素 (2 和 1) 2 的右侧仅有 1 个更小的元素
 * (1) 6 的右侧有 1 个更小的元素 (1) 1 的右侧有 0 个更小的元素
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= nums.length <= 10^5 -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class FenwickTree {
    // 前缀和
    int[] tree;
    int len;

    FenwickTree(int length) {
        tree = new int[length + 1];
        len = length;
    }

    int query(int i) {
        int sum = 0;
        while (i >= 0) {
            sum += tree[i];
            i -= lowBit(i);
        }
        return sum;
    }

    void update(int i, int delta) {
        while (i <= this.len) {
            tree[i] += delta;
            i += lowBit(i);
        }
    }

    int lowBit(int i) {
        return i & (~i + 1);
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        if (nums.length == 0) {
            return list;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            set.add(nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer item : set) {
            map.put(item, rank++);
        }
        FenwickTree fenwickTree = new FenwickTree(set.size());
        for (int i = nums.length - 1; i >= 0; i--) {
            rank = map.get(nums[i]);
            fenwickTree.update(rank, 1);
            list.addFirst(fenwickTree.query(rank - 1));
        }
        return list;
    }
}
// @lc code=end