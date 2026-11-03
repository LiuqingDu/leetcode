/*
 * @lc app=leetcode.cn id=1561 lang=javascript
 *
 * [1561] 你可以获得的最大硬币数目
 */

// @lc code=start
/**
 * @param {number[]} piles
 * @return {number}
 */
var maxCoins = function(piles) {
    let n = piles.length;
    let l = n / 3;
    let res = 0;
    piles = piles.sort((a, b) => a - b)
    for (let i = l; i < n - 1; i+=2) {
        res += piles[i];
    }
    return res;
};
// @lc code=end

