/*
 * @lc app=leetcode.cn id=2506 lang=javascript
 *
 * [2506] 统计相似字符串对的数目
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {number}
 */
var similarPairs = function(words) {
    let res = 0;
    const cnt = new Map();
    for (const word of words) {
        let state = 0;
        for (const c of word) {
            state |= 1 << (c.charCodeAt(0) - 'a'.charCodeAt(0));
        }
        res += cnt.get(state) || 0;
        cnt.set(state, (cnt.get(state) || 0) + 1);
    }
    return res;
};
// @lc code=end

