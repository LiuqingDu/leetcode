/*
 * @lc app=leetcode.cn id=290 lang=javascript
 *
 * [290] 单词规律
 */

// @lc code=start
/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
var wordPattern = function(pattern, s) {

    let patternHelper = function(strs) {
        let map = new Map();
        let count = 1;
        let res = "";
        for (let str of strs) {
            if (map.has(str)) {
                res += map.get(str);
            } else {
                map.set(str, count);
                res += count;
                count++;
            }
        }
        return res;
    }

    let strs1 = pattern.split("");
    let strs2 = s.split(" ");
    if (strs1.length !== strs2.length) {
        return false;
    }

    return patternHelper(strs1) === patternHelper(strs2);
};
// @lc code=end

