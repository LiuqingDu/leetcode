/*
 * @lc app=leetcode.cn id=3024 lang=javascript
 *
 * [3024] 三角形类型
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {string}
 */
var triangleType = function(nums) {
    
    // 1. 排序（从小到大）
    nums.sort((a, b) => a - b);
    
    let [a, b, c] = nums;
    
    // 2. 判断是否能构成三角形
    if (a + b <= c) {
        return "none";
    }
    
    // 3. 判断类型
    if (a === b && b === c) {
        return "equilateral";
    } else if (a === b || b === c || a === c) {
        return "isosceles";
    } else {
        return "scalene";
    }
};
// @lc code=end

