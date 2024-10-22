/*
 * @lc app=leetcode.cn id=395 lang=javascript
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var longestSubstring = function(s, k) {
    if (s.length < k) {
        return 0;
    }

    let map = new Map();
    for (let i = 0; i < s.length; i++) {
        let c = s[i];
        map.set(c, (map.get(c) || 0) + 1);
    }

    for (let [c, count] of map) {
        if (count < k) {
            let res = 0;
            let substrings = s.split(c);
            for (let sub of substrings) {
                res = Math.max(res, longestSubstring(sub, k));
            }
            return res;
        }
    }
    
    return s.length;
};
// @lc code=end

