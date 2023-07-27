/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 从最后一天往前倒着看
        // 某一天能获取的最大利润是未来最大值减去当天价格
        // 包含当前的未来最大值是当天价格与未来最大值当中更大的那个
        // 倒着往前，一边更新未来最高价，一边计算当天可获取的最大利润并更新全局的最大利润
        int n = prices.length;
        int high = 0;
        int res = 0;

        for (int i = n - 1; i >= 0; i--) {
            // 计算这一天及之后的最高价
            high = Math.max(high, prices[i]);
            // 今天能获取的最大利润取决于未来最高价减去今天价格
            // 然后再用今天的利润去更新全局的最高利润
            res = Math.max(res, high - prices[i]);
        }
        return res;
    }
}
// @lc code=end

