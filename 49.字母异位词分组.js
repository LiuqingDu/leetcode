/*
 * @lc app=leetcode.cn id=49 lang=javascript
 *
 * [49] 字母异位词分组
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {

    let map = new Map();

    strs.forEach(v => {
        let s = v.split("").sort().join("");
        if (!map.has(s)) {
            map.set(s, new Array());
        }
        map.get(s).push(v);
    })

    return Array.from(map.values());

};
// @lc code=end

