/*
 * @lc app=leetcode.cn id=771 lang=javascript
 *
 * [771] 宝石与石头
 */

// @lc code=start
/**
 * @param {string} jewels
 * @param {string} stones
 * @return {number}
 */
var numJewelsInStones = function(jewels, stones) {
    let arr = new Array(128).fill(false);
    for (let i = 0; i < jewels.length; i++) {
        arr[jewels.charCodeAt(i)] = true;
    }

    let res = 0;
    for (let i = 0; i < stones.length; i++) {
        if (arr[stones.charCodeAt(i)]) {
            res++;
        }
    }
    return res;
};
// @lc code=end

