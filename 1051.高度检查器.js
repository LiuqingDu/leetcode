/*
 * @lc app=leetcode.cn id=1051 lang=javascript
 *
 * [1051] 高度检查器
 */

// @lc code=start
/**
 * @param {number[]} heights
 * @return {number}
 */
var heightChecker = function(heights) {
    let count = new Array(101).fill(0);
    
    for (let h of heights) {
        count[h]++;
    }
    
    let index = 0, mismatch = 0;
    
    for (let h = 1; h <= 100; h++) {
        while (count[h] > 0) {
            if (heights[index] !== h) {
                mismatch++;
            }
            index++;
            count[h]--;
        }
    }
    
    return mismatch;
};
// @lc code=end

