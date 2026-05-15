/*
 * @lc app=leetcode.cn id=1344 lang=javascript
 *
 * [1344] 时钟指针的夹角
 */

// @lc code=start
/**
 * @param {number} hour
 * @param {number} minutes
 * @return {number}
 */
var angleClock = function(hour, minutes) {
    // 分针角度
    let minuteAngle = minutes * 6;

    // 时针角度
    let hourAngle = (hour % 12) * 30 + minutes * 0.5;

    // 两者夹角
    let diff = Math.abs(hourAngle - minuteAngle);

    // 返回较小角度
    return Math.min(diff, 360 - diff);
};
// @lc code=end

