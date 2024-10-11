/*
 * @lc app=leetcode.cn id=318 lang=javascript
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {number}
 */
var maxProduct = function(words) {
    let map = new Map();
    let n = words.length;

    for (let i = 0; i < n; i++) {
        let mask = 0;
        let word = words[i];
        let l = word.length;
        for (let j = 0; j < l; j++) {
            mask |= 1 << (word.charCodeAt(j) - 'a'.charCodeAt(0));
        }
        if (l > (map.get(mask) || 0)) {
            map.set(mask, l);
        }
    }
    let res = 0;
    let maskSet = Array.from(map.keys());
    for (let mask1 of maskSet) {
        let l1 = map.get(mask1);
        for (let mask2 of maskSet) {
            if ((mask1 & mask2) === 0) {
                let l2 = map.get(mask2);
                res = Math.max(res, l1 * l2);
            }
        }
    }
    return res;
};
// @lc code=end

