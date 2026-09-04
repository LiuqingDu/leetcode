/*
 * @lc app=leetcode.cn id=1608 lang=javascript
 *
 * [1608] 特殊数组的特征值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var specialArray = function(nums) {
    
    nums.sort((a, b) => a - b);
    const n = nums.length;
    for (let i = 0, j = n - 1; i < j; i++, j--) {
        const temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    for (let i = 1; i <= n; ++i) {
        if (nums[i - 1] >= i && (i === n || nums[i] < i)) {
            return i;
        }
    }
    return -1;
};
// @lc code=end

