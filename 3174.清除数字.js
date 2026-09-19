/*
 * @lc app=leetcode.cn id=3174 lang=javascript
 *
 * [3174] 清除数字
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var clearDigits = function(s) {
    
    let res = [];
    for (let c of s){
        if (c >= '0' && c <= '9') {
            res.pop();
        } else {
            res.push(c);
        }
    }
    return res.join('');

};
// @lc code=end

