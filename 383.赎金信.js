/*
 * @lc app=leetcode.cn id=383 lang=javascript
 *
 * [383] 赎金信
 */

// @lc code=start
/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
    let map = new Array(26).fill(0);
    let n = 0;
    for (let c of ransomNote) {
        if (map[c.charCodeAt(0) - 'a'.charCodeAt(0)] === 0) {
            n++;
        }
        map[c.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

    for (let c of magazine) {
        map[c.charCodeAt(0) - 'a'.charCodeAt(0)]--;
        if (map[c.charCodeAt(0) - 'a'.charCodeAt(0)] === 0) {
            n--;
        }
    }

    return  n === 0;

};
// @lc code=end

