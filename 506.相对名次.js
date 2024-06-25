/*
 * @lc app=leetcode.cn id=506 lang=javascript
 *
 * [506] 相对名次
 */

// @lc code=start
/**
 * @param {number[]} score
 * @return {string[]}
 */
var findRelativeRanks = function(score) {
    let res = [];
    let ss = ["Gold Medal","Silver Medal","Bronze Medal"];
    let copy = [...score];
    let map = new Map();
    copy.sort((a, b) => a - b);
    for (let i = 0; i < copy.length; i++) {
        map.set(copy[i], copy.length - 1 - i)
    }
    for (let c of score) {
        res.push(m0ap.get(c) < 3 ? ss[map.get(c)] : map.get(c) + 1 + "");
    }
    return res;

};
// @lc code=end

