/*
 * @lc app=leetcode.cn id=16 lang=javascript
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {

    nums.sort((a, b) => a - b);

    let res = nums[0] + nums[1] + nums[2];
    for (let first = 0; first < nums.length; first++) {
        let second = first + 1, third = nums.length - 1;
        while (second < third) {
            let sum = nums[first] + nums[second] + nums[third];
            if (Math.abs(sum - target) < Math.abs(res - target)) {
                res = sum;
            }
            if (sum > target) {
                third--;
            } else if (sum < target) {
                second++;
            } else if (sum === target) {
                return sum;
            }
        }
    }
    return res;
};
// @lc code=end

