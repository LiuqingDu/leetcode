/*
 * @lc app=leetcode.cn id=740 lang=javascript
 *
 * [740] 删除并获得点数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
    let rob = function(nums) {
        const size = nums.length;
        let first = nums[0], second = Math.max(nums[0], nums[1]);
        for (let i = 2; i < size; i++) {
            let temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    let maxVal = 0;
    for (const val of nums) {
        maxVal = Math.max(maxVal, val);
    }
    const sum = new Array(maxVal + 1).fill(0);
    for (const val of nums) {
        sum[val] += val;
    }
    return rob(sum);
};
// @lc code=end

