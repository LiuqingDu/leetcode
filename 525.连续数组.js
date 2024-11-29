/*
 * @lc app=leetcode.cn id=525 lang=javascript
 *
 * [525] 连续数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
    let cur = 0;
    let res = 0;
    const map = new Map();
    map.set(0, -1);

    for (let i = 0; i < nums.length; i++) {
        cur += nums[i] === 0 ? -1 : 1;
        if (map.has(cur)) {
            res = Math.max(res, i - map.get(cur));
        } else {
            map.set(cur, i);
        }
    }

    return res;
};
// @lc code=end

