/*
 * @lc app=leetcode.cn id=2269 lang=javascript
 *
 * [2269] 找到一个数字的 K 美丽值
 */

// @lc code=start
/**
 * @param {number} num
 * @param {number} k
 * @return {number}
 */
var divisorSubstrings = function(num, k) {
    const str = num.toString();
    let count = 0;
    for (let i = 0; i <= str.length - k; i++) {
        const sub = str.slice(i, i + k);
        const subNum = Number(sub);
        if (subNum !== 0 && num % subNum === 0) {
            count++;
        }
    }
    return count;
};
// @lc code=end

