/*
 * @lc app=leetcode.cn id=3019 lang=javascript
 *
 * [3019] 按键变更的次数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var countKeyChanges = function(s) {
    
    let count = 0;
    
    // 转小写
    s = s.toLowerCase();
    
    for (let i = 1; i < s.length; i++) {
        if (s[i] !== s[i - 1]) {
            count++;
        }
    }
    
    return count;
};
// @lc code=end

