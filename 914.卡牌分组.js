/*
 * @lc app=leetcode.cn id=914 lang=javascript
 *
 * [914] 卡牌分组
 */

// @lc code=start
/**
 * @param {number[]} deck
 * @return {boolean}
 */
var hasGroupsSizeX = function(deck) {

    let gcd = function(x, y) {
        return x === 0 ? y : gcd(y % x, x);
    }

    let arr = new Array(10000).fill(0);
    for (let c of deck) {
        arr[c]++;
    }

    let g = -1;
    for (let i = 0; i < arr.length; i++) {
        if (g === -1) {
            g = arr[i];
        } else {
            g = gcd(g, arr[i]);
        }
    }

    return g >= 2;
};
// @lc code=end

