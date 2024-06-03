/*
 * @lc app=leetcode.cn id=387 lang=javascript
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    let map = new Map();
    for (let c of s) {
        if (!map.has(c)) {
            map.set(c, 0);
        }
        map.set(c, map.get(c) + 1);
    }
    for (let i = 0; i < s.length; i++) {
        if (map.has(s[i]) && map.get(s[i]) === 1) {
            return i;
        }
    }
    return -1;

};
// @lc code=end

