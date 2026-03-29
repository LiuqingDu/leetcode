/*
 * @lc app=leetcode.cn id=3014 lang=javascript
 *
 * [3014] 输入单词需要的最少按键次数 I
 */

// @lc code=start
/**
 * @param {string} word
 * @return {number}
 */
var minimumPushes = function(word) {
    
    let res = 0;
    
    for (let i = 0; i < word.length; i++) {
        res += Math.floor(i / 8) + 1;
    }
    
    return res;
};
// @lc code=end

