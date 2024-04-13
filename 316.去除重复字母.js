/*
 * @lc app=leetcode.cn id=316 lang=javascript
 *
 * [316] 去除重复字母
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicateLetters = function(s) {

    let countMap = s.split("").reduce((pre, cur) => {
        pre.set(cur, (pre.get(cur) || 0) + 1);
        return pre;
    }, new Map());

    let res = [];

    for (let c of s.split("")) {
        if (!res.includes(c)) {
            while(res.length 
                && (c.charCodeAt(0) < res[res.length - 1].charCodeAt(0)) 
                && (countMap.get(res[res.length - 1]) > 0)) {
                res.pop();
            }
            res.push(c);
        }
        countMap.set(c, countMap.get(c) - 1);
    }

    return res.join("");

};
// @lc code=end

