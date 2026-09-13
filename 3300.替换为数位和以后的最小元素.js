/*
 * @lc app=leetcode.cn id=3300 lang=javascript
 *
 * [3300] 替换为数位和以后的最小元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minElement = function(nums) {
    let res = 37;

    for (let num of nums) {
        let dig = 0;
        while (num > 0) {
            dig += num % 10;
            num = Math.floor(num / 10);
        }
        res = Math.min(res, dig);
    }
    return res;
};
// @lc code=end

