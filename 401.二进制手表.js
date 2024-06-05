/*
 * @lc app=leetcode.cn id=401 lang=javascript
 *
 * [401] 二进制手表
 */

// @lc code=start
/**
 * @param {number} turnedOn
 * @return {string[]}
 */
var readBinaryWatch = function(turnedOn) {
    // 分别表示总共几个灯，当前已经点亮几个灯，当前在第几个灯上，当前已经点亮的“时”的总和，当前已经点亮的“分”的总和
    // 时的所有可能，分的所有可能，最终结果
    let backtrack = function(target, current, ind, hour, minute, hours, minutes, res) {
        if (hour > 11 || minute > 59) {
            return;
        }
        if (target === current) {
            let str = "";
            str += hour;
            str += ":";
            if (minute < 10) {
                str += "0";
            }
            str += minute;
            res.push(str);
            return;
        }
        for (let i = ind; i < 10; i++) {
            backtrack(target, current + 1, i + 1, hour + hours[i], minute + minutes[i], hours, minutes, res);
        }
    }
    let hours = [1, 2, 4, 8, 0, 0, 0, 0, 0, 0];
    let minutes = [0, 0, 0, 0, 1, 2, 4, 8, 16, 32];

    let res = [];
    backtrack(turnedOn, 0, 0, 0, 0, hours, minutes, res);
    return res;

};
// @lc code=end

