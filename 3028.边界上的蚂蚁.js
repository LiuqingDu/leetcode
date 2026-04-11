/*
 * @lc app=leetcode.cn id=3028 lang=javascript
 *
 * [3028] 边界上的蚂蚁
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var returnToBoundaryCount = function(nums) {
    
    let position = 0; // 当前坐标
    let count = 0;    // 返回边界次数

    for (let num of nums) {
        position += num; // 移动
        
        if (position === 0) {
            count++; // 回到边界
        }
    }

    return count;
};
// @lc code=end

