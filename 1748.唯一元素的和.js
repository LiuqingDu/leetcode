/*
 * @lc app=leetcode.cn id=1748 lang=javascript
 *
 * [1748] 唯一元素的和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfUnique = function(nums) {
    let ans = 0;
    const state = new Map();
    for (const num of nums) {
        if (!state.has(num)) {
            ans += num;
            state.set(num, 1);
        } else if (state.get(num) === 1) {
            ans -= num;
            state.set(num, 2);
        }
    }
    return ans;
};
// @lc code=end

