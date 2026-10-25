/*
 * @lc app=leetcode.cn id=3637 lang=javascript
 *
 * [3637] 三段式数组 I
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isTrionic = function(nums) {
    
    const n = nums.length;
    let p = -1, q = -1, flag = -1, i = 1;
    while (i < n && nums[i - 1] < nums[i]) {
        i++;
    }
    p = i - 1;
    
    while (i < n && nums[i - 1] > nums[i]) {
        i++;
    }
    q = i - 1;
    
    while (i < n && nums[i - 1] < nums[i]) {
        i++;
    }
    flag = i - 1;
    
    return (p !== 0) && (q !== p) && (flag === n - 1 && flag !== q);

};
// @lc code=end

