/*
 * @lc app=leetcode.cn id=1344 lang=java
 *
 * [1344] 时钟指针的夹角
 */

// @lc code=start
class Solution {
    public double angleClock(int hour, int minutes) {
        // 分针角度
        double minuteAngle = minutes * 6;

        // 时针角度
        double hourAngle = (hour % 12) * 30 + minutes * 0.5;

        // 两者差值
        double diff = Math.abs(hourAngle - minuteAngle);

        // 返回较小夹角
        return Math.min(diff, 360 - diff);
    }
}
// @lc code=end

