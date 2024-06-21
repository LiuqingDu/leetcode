/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // 遍历每一个时间点，比较上一个中毒时间的结束点（s+duration-1）跟现在的时间点的关系
        // 从而判断上一个中毒时间是否完整，
        // 完整的话，这一次新的中毒时间就是完整的
        // 不完整的话，那么当前这一次中毒相当于延长了上一次中毒时间，
        // 延长的部分相当于这一次的结束时间减去上一次的结束时间
        // 累加每次新增的中毒时间
        int res = 0, last = -1;
        for (int s: timeSeries) {
            // end表示这一次的结束时间
            int end = s + duration - 1;
            // 判断上一次结束时间跟这一次开始时间的关系
            if (last < s) {
                res += duration;
            } else {
                res += end - last;
            }
            // 记录新的结束时间
            last = end;
        }
        return res;
    }
}
// @lc code=end

