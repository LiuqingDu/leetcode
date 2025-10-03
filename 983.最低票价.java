/*
 * @lc app=leetcode.cn id=983 lang=java
 *
 * [983] 最低票价
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // dp
        // 因为一张通行证可以保证未来的通行,所以我们可以从后往前计算
        // dp[i]表示从第i天到年底最后一天的最低总花费
        // 如果这一天不出行,那么这一天就不买票,dp[i]=dp[i+1]
        // 如果这一天出行,那么我们有三种买票方式,买1天的票,买7天的票,买30天的票
        // 买1天的票,那么dp[i]=costs[0]+dp[i+1]
        // 买7天的票,那么dp[i]=costs[1]+dp[i+7]
        // 买30天的票,那么dp[i]=costs[2]+dp[i+30]
        // 因为买了一张票之后,要最大化利用这个票,那么在此期间都不用再买票
        // 另外dp可以创建大一点,首先是dp[0]不会用到,另外年底之后再多30天用于避免越界

        Set<Integer> travelDays = new HashSet<>();
        for (int d : days) {
            travelDays.add(d);
        }

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 30 + 1]; // 多开30，避免越界, 多的 1 是dp[0]

        for (int i = lastDay; i >= 1; i--) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i + 1]; // 不旅行
            } else {
                dp[i] = Math.min(
                    costs[0] + dp[i + 1],
                    Math.min(
                        costs[1] + dp[i + 7],
                        costs[2] + dp[i + 30]
                    )
                );
            }
        }

        return dp[1];
    }
}
// @lc code=end

