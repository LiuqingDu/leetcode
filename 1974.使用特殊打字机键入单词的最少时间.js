/*
 * @lc app=leetcode.cn id=1974 lang=javascript
 *
 * [1974] 使用特殊打字机键入单词的最少时间
 */

// @lc code=start
/**
 * @param {string} word
 * @return {number}
 */
var minTimeToType = function(word) {
    let time = 0;
    let prev = 'a';
    
    for (let char of word) {
        let distance = Math.abs(char.charCodeAt(0) - prev.charCodeAt(0));
        distance = Math.min(distance, 26 - distance);
        time += distance + 1;
        prev = char;
    }
    
    return time;
};
// @lc code=end

