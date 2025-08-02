/*
 * @lc app=leetcode.cn id=2073 lang=java
 *
 * [2073] 买票需要的时间
 */

// @lc code=start
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // 不要想着把人挪到队伍末尾
        // 而是变换思路,人不动,售票员动
        // 先把每个人的第一张票卖掉, 然后卖每个人的第二张票,以此类推
        // 直到卖到第k个人的最后一张票,记这个人要买m张票
        // 那么他前面的人都买了最多m张票,他后面的人买了最多m-1张票
        // 当然这些人实际买的票应当是他们需求票数跟m或者m-1的最小值
        int sum = 0;
        int n = tickets.length;
        int m = tickets[k]; // 第k个人需要买的票数
        for (int i = 0; i < n; i++) {
            // 如果是k人或者他之前的,那么最多买m张票,跟实际需求取小
            if (i <= k) {
                sum += Math.min(tickets[i], m);
            } else {
                // 如果是k人之后的,那么最多买m-1张票,跟实际需求取小
                sum += Math.min(tickets[i], m - 1);
            }
        }
        return sum;
    }
}
// @lc code=end

