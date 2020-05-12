import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (52.12%)
 * Likes:    459
 * Dislikes: 0
 * Total Accepted:    96.7K
 * Total Submissions: 183.7K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * 
 * 
 * 
 * 
 * 示例:
 * 
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * 
 * 
 */

// @lc code=start
class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        data.push(x);
        if (!min.isEmpty()) {
            int top = min.peek();
            if (top >= x) {
                min.push(x);
            }
        } else {
            min.push(x);
        }
    }

    public void pop() {
        int temp = 0;
        if (!data.isEmpty()) {
            temp = data.pop();
        }
        if (!min.isEmpty()) {
            if (min.peek() == temp) {
                min.pop();
            }
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        if (!min.isEmpty()) {
            return min.peek();
        }
        throw new IndexOutOfBoundsException("越界了");
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */

// @lc code=end
