/*
 * @lc app=leetcode.cn id=611 lang=javascript
 *
 * [611] 有效三角形的个数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var triangleNumber = function(nums) {
    nums.sort((a, b) => a - b);
    let res = 0;
    for (let k = nums.length - 1; k > 1; k--) {
        let i = 0;
        let j = k - 1;
        while (i < j) {
            if (nums[i] + nums[j] > nums[k]) {
                res += (j - i);
                j--;
            } else {
                i++;
            }
        }
    }
    return res;
};
// @lc code=end

