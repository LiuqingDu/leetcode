/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] 股票价格跨度
 */

// @lc code=start
class StockSpanner {
    // 栈中存放 [价格, 连续天数]
    private Stack<int[]> stack;

    // 构造函数，初始化空栈
    public StockSpanner() {
        stack = new Stack<>();
    }

    // 处理当天股票价格，返回跨度
    public int next(int price) {
        // 每天至少包含自己一天，所以初始跨度为 1
        int span = 1;

        // 如果栈顶价格 <= 当前价格，说明当前价格比前几天都高或相等
        // 那么可以把前几天的跨度合并进来
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];  // 累加被弹出的天数
        }

        // 把当前价格和对应的跨度入栈
        stack.push(new int[]{price, span});

        // 返回今天的价格跨度
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

