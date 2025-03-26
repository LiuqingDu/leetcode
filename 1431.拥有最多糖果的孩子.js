/*
 * @lc app=leetcode.cn id=1431 lang=javascript
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
/**
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
var kidsWithCandies = function(candies, extraCandies) {
    let max = 0;
    for (let candy of candies) {
        max = Math.max(max, candy);
    }

    let res = [];
    for (let candy of candies) {
        res.push(candy + extraCandies >= max);
    }
    return res;
};
// @lc code=end

