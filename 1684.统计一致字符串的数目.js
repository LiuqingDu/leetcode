/*
 * @lc app=leetcode.cn id=1684 lang=javascript
 *
 * [1684] 统计一致字符串的数目
 */

// @lc code=start
/**
 * @param {string} allowed
 * @param {string[]} words
 * @return {number}
 */
var countConsistentStrings = function(allowed, words) {
    let mask = 0;
    for (let i = 0; i < allowed.length; i++) {
        const c = allowed[i];
        mask |= 1 << (c.charCodeAt() - 'a'.charCodeAt());
    }
    let res = 0;
    for (const word of words) {
        let mask1 = 0;
        for (let i = 0; i < word.length; i++) {
            const c = word[i];
            mask1 |= 1 << (c.charCodeAt() - 'a'.charCodeAt());
        }
        if ((mask1 | mask) === mask) {
            res++;
        }
    }
    return res;
};
// @lc code=end

