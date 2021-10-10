import java.util.*;
/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 *
 * https://leetcode-cn.com/problems/find-median-from-data-stream/description/
 *
 * algorithms
 * Hard (48.63%)
 * Likes:    280
 * Dislikes: 0
 * Total Accepted:    24K
 * Total Submissions: 49.1K
 * Testcase Example:  '["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]\n' +
  '[[],[1],[2],[],[3],[]]'
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 
 * 例如，
 * 
 * [2,3,4] 的中位数是 3
 * 
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 
 * 设计一个支持以下两种操作的数据结构：
 * 
 * 
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 
 * 
 * 示例：
 * 
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3) 
 * findMedian() -> 2
 * 
 * 进阶:
 * 
 * 
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 
 * 
 */

// @lc code=start
class MedianFinder {
    // 最小堆存后面最大的元素
    Queue<Integer> min;
    // 最大堆存前面最小的元素
    Queue<Integer> max;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>((item1, item2) -> {
            return item2 - item1;
        });
    }

    public void addNum(int num) {
        if (min.isEmpty() && max.isEmpty()) {
            min.offer(num);
            return;
        }
        // 如果最小堆个数小于最大堆
        if (min.size() < max.size()) {
            // 如果最大堆最小值小于这个数，加入到最小堆
            if (max.peek() <= num) {
                min.offer(num);
                // 如果最大堆最小值大于这个数，不能直接加入最小堆
                // 只能先吧最大堆的堆首取出加入到最小堆，再把这个数加入到最大堆
            } else {
                min.offer(max.poll());
                max.offer(num);
            }
            // 与上面情况类似
        } else if (min.size() > max.size()) {
            if (min.peek() >= num) {
                max.offer(num);
            } else {
                max.offer(min.poll());
                min.offer(num);
            }
        } else {
            if (max.peek() <= num) {
                min.offer(num);
            } else {
                max.offer(num);
            }
        }
    }

    public double findMedian() {
        if (!min.isEmpty() && !max.isEmpty()) {
            System.out.println(min.peek() + " " + max.peek());
            if (min.size() == max.size()) {
                return (double) (min.peek() + max.peek()) / 2;
            } else if (min.size() > max.size()) {
                return min.peek();
            } else {
                return max.peek();
            }
        }
        if (min.isEmpty()) {
            return max.peek();
        } else {
            return min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
// @lc code=end
