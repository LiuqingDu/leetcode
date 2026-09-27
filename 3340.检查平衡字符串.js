/*
 * @lc app=leetcode.cn id=3340 lang=javascript
 *
 * [3340] 检查平衡字符串
 */

// @lc code=start
/**
 * @param {string} num
 * @return {boolean}
 */
var isBalanced = function(num) {
    
    let diff = 0, sign = 1;
    for (let c of num) {
        let d = parseInt(c);
        diff += d * sign;
        sign = -sign;
    }
    return diff === 0;

};
// @lc code=end

