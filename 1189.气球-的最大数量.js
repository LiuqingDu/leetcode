/*
 * @lc app=leetcode.cn id=1189 lang=javascript
 *
 * [1189] “气球” 的最大数量
 */

// @lc code=start
/**
 * @param {string} text
 * @return {number}
 */
var maxNumberOfBalloons = function(text) {
    let target = new Array(26).fill(0);
    let str = "balloon";
    for (let i = 0; i < str.length; i++) {
        target[str.charCodeAt(i) - 'a'.charCodeAt(0)]++;
    }

    let arr = new Array(26).fill(0);
    for (let i = 0; i < text.length; i++) {
        arr[text.charCodeAt(i) - 'a'.charCodeAt(0)]++;
    }

    let res = Number.MAX_SAFE_INTEGER;
    for (let i = 0; i < 26; i++) {
        if (target[i] === 0) {
            continue;
        }
        let n = Math.floor(arr[i] / target[i]);
        res = Math.min(res, n);
    }

    return res;
};
// @lc code=end

