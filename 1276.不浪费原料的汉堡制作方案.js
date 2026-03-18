/*
 * @lc app=leetcode.cn id=1276 lang=javascript
 *
 * [1276] 不浪费原料的汉堡制作方案
 */

// @lc code=start
/**
 * @param {number} tomatoSlices
 * @param {number} cheeseSlices
 * @return {number[]}
 */
var numOfBurgers = function(tomatoSlices, cheeseSlices) {
    
    if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || cheeseSlices * 4 < tomatoSlices) {
        return []
    }
    return [(tomatoSlices >> 1) - cheeseSlices, cheeseSlices * 2 - (tomatoSlices >> 1)];
};
// @lc code=end

