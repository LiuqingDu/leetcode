/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<Integer>();

        // 单调栈，从后往前找，把比当前元素小的都删掉
        // 栈里存大元素的下标
        for (int i = n - 1; i >= 0; i --) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            // 如果栈为空，则当前数最大，返回值为0，
            //  如果栈不为空，则用栈顶存的下标减去当前下标即为结果
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }

        return res;
    }
}
// @lc code=end

