/*
 * @lc app=leetcode.cn id=2960 lang=javascript
 *
 * [2960] 统计已测试设备
 */

// @lc code=start
/**
 * @param {number[]} batteryPercentages
 * @return {number}
 */
var countTestedDevices = function(batteryPercentages) {
    let n = batteryPercentages.length;
    let res = 0;
    for (let i = 0; i < n; i++) {
        if (batteryPercentages[i] > 0) {
            res++;
            for (let j = i + 1; j < n; j++) {
                batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
            }
        }
    }
    return res;
};
// @lc code=end

