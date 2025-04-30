/*
 * @lc app=leetcode.cn id=1629 lang=javascript
 *
 * [1629] 按键持续时间最长的键
 */

// @lc code=start
/**
 * @param {number[]} releaseTimes
 * @param {string} keysPressed
 * @return {character}
 */
var slowestKey = function(releaseTimes, keysPressed) {
    let res = keysPressed[0];
    let pre = releaseTimes[0];
    let n = releaseTimes.length;
    for (let i = 1; i < n; i++) {
        let diff = releaseTimes[i] - releaseTimes[i - 1];
        if (diff > pre) {
            pre = diff;
            res = keysPressed[i];
        }
        if (diff === pre && res.charCodeAt(0) < keysPressed.charCodeAt(i)) {
            res = keysPressed[i];
        }
    }
    return res;
};
// @lc code=end

