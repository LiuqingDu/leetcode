/*
 * @lc app=leetcode.cn id=128 lang=javascript
 *
 * [128] 最长连续序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {

    let set = new Set();

    for (let i = 0; i < nums.length; i++) {
        set.add(nums[i]);
    }

    let res = 0;

    for (let n of set) {
        if (!set.has(n - 1)) {
            let i = n;
            let count = 0;
            while (set.has(i)) {
                count++;
                i++;
            }
            res = Math.max(res, count);
        }
    }

    return res;

};
// @lc code=end

