/*
 * @lc app=leetcode.cn id=1103 lang=javascript
 *
 * [1103] 分糖果 II
 */

// @lc code=start
/**
 * @param {number} candies
 * @param {number} num_people
 * @return {number[]}
 */
var distributeCandies = function(candies, num_people) {
    
    const ans = new Array(num_people).fill(0);
    let i = 0;
    while (candies !== 0) {
        ans[i % num_people] += Math.min(candies, i + 1);
        candies -= Math.min(candies, i + 1);
        i++;
    }
    return ans;
};
// @lc code=end

