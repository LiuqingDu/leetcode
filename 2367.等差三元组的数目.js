/*
 * @lc app=leetcode.cn id=2367 lang=javascript
 *
 * [2367] 等差三元组的数目
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} diff
 * @return {number}
 */
var arithmeticTriplets = function(nums, diff) {
  const set = new Set();
  let res = 0;
  for (const num of nums) {
    set.add(num);
    set.has(num - diff) && set.has(num - 2 * diff) && res++;
  }
  return res;
};
// @lc code=end

