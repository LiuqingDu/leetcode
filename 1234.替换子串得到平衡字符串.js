/*
 * @lc app=leetcode.cn id=1234 lang=javascript
 *
 * [1234] 替换子串得到平衡字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var balancedString = function(s) {
    
    const n = s.length
    const target = n / 4
    
    const count = {
        Q:0,
        W:0,
        E:0,
        R:0
    }
    
    // 统计字符
    for (let c of s) {
        count[c]++
    }
    
    // 如果已经平衡
    if (
        count.Q === target &&
        count.W === target &&
        count.E === target &&
        count.R === target
    ) {
        return 0
    }
    
    let left = 0
    let res = n
    
    for (let right = 0; right < n; right++) {
        
        count[s[right]]--
        
        while (
            count.Q <= target &&
            count.W <= target &&
            count.E <= target &&
            count.R <= target
        ) {
            res = Math.min(res, right - left + 1)
            
            count[s[left]]++
            left++
        }
    }
    
    return res
};
// @lc code=end

