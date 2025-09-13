/*
 * @lc app=leetcode.cn id=916 lang=javascript
 *
 * [916] 单词子集
 */

// @lc code=start
/**
 * @param {string[]} words1
 * @param {string[]} words2
 * @return {string[]}
 */
var wordSubsets = function(words1, words2) {
    const getCount = (word) => {
        const count = new Array(26).fill(0);
        for (let c of word) {
            count[c.charCodeAt() - 'a'.charCodeAt()]++;
        }
        return count;
    };
    const maxCount = new Array(26).fill(0);
    for (let word of words2) {
        const count = getCount(word);
        for (let i = 0; i < 26; i++) {
            maxCount[i] = Math.max(maxCount[i], count[i]);
        }
    }
    const res = [];
    for (let word of words1) {
        const count = getCount(word);
        let isSubset = true;
        for (let i = 0; i < 26; i++) {
            if (count[i] < maxCount[i]) {
                isSubset = false;
                break;
            }
        }
        if (isSubset) {
            res.push(word);
        }
    }
    return res;
};
// @lc code=end

