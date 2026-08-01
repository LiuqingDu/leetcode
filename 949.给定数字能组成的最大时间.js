/*
 * @lc app=leetcode.cn id=949 lang=javascript
 *
 * [949] 给定数字能组成的最大时间
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {string}
 */
var largestTimeFromDigits = function(arr) {
    
    let maxTime = -1;

    // 穷举 4 个数字的所有排列组合
    for (let i = 0; i < 4; i++) {
        for (let j = 0; j < 4; j++) {
            if (j === i) continue;
            for (let k = 0; k < 4; k++) {
                if (k === i || k === j) continue;
                for (let l = 0; l < 4; l++) {
                    if (l === i || l === j || l === k) continue;

                    let hours = arr[i] * 10 + arr[j];
                    let minutes = arr[k] * 10 + arr[l];

                    // 验证是否符合 24 小时制规则
                    if (hours < 24 && minutes < 60) {
                        let totalMinutes = hours * 60 + minutes;
                        maxTime = Math.max(maxTime, totalMinutes);
                    }
                }
            }
        }
    }

    if (maxTime < 0) return "";

    // 格式化输出为 "HH:MM"
    let h = Math.floor(maxTime / 60).toString().padStart(2, '0');
    let m = (maxTime % 60).toString().padStart(2, '0');

    return `${h}:${m}`;
};
// @lc code=end

