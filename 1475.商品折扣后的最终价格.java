/*
 * @lc app=leetcode.cn id=1475 lang=java
 *
 * [1475] 商品折扣后的最终价格
 */

// @lc code=start
class Solution {
    public int[] finalPrices(int[] prices) {
        // 用单调栈来避免对于每一个价格要重复遍历它后面的价格的过程
        // 从右往左遍历价格来维护一个单调栈, 当价格小于栈顶的时候,
        // 弹出栈顶直到大于栈顶,然后价格入栈
        // 形成一个单调递增的栈
        // 同时判断价格, 新价格入栈前,栈顶小于当前价格,
        // 直接减去栈顶即为优惠后价格

        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }
}
// @lc code=end

