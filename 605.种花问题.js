/*
 * @lc app=leetcode.cn id=605 lang=javascript
 *
 * [605] 种花问题
 */

// @lc code=start
/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
var canPlaceFlowers = function(flowerbed, n) {
    let m = flowerbed.length;
    for (let i = 0; i < m; i++) {
        if ((i === 0 || flowerbed[i - 1] === 0) && flowerbed[i] === 0 && (i === m - 1 || flowerbed[i + 1] === 0)) {
            n--;
            i++;
        }
    }
    return n <= 0;
};
// @lc code=end

