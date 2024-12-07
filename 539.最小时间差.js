/*
 * @lc app=leetcode.cn id=539 lang=javascript
 *
 * [539] 最小时间差
 */

// @lc code=start
/**
 * @param {string[]} timePoints
 * @return {number}
 */
var findMinDifference = function(timePoints) {
    let n = timePoints.length;
    if (n > 1440) {
        return 0;
    }

    let timeTable = new Array(1440 * 2).fill(0);
    for (let s of timePoints) {
        let [h, m] = s.split(":").map(Number);
        timeTable[h * 60 + m]++;
        timeTable[h * 60 + m + 1440]++;
    }

    let res = 720, pre = -1;
    for (let i = 0; i < 1440 * 2 && res !== 0; i++) {
        if (timeTable[i] === 0) {
            continue;
        }
        
        if (timeTable[i] > 1) {
            return 0;
        }
        
        if (pre !== -1) {
            res = Math.min(res, i - pre);
        }
        pre = i;
    }
    return res;
};
// @lc code=end

