/*
 * @lc app=leetcode.cn id=2273 lang=javascript
 *
 * [2273] 移除字母异位词后的结果数组
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {string[]}
 */
var removeAnagrams = function(words) {
    
    const compare = (word1, word2) => {
        let freq = new Array(26).fill(0);
        for (let ch of word1) {
            freq[ch.charCodeAt(0) - 'a'.charCodeAt(0)]++;
        }
        for (let ch of word2) {
            freq[ch.charCodeAt(0) - 'a'.charCodeAt(0)]--;
        }
        return freq.every(x => x === 0);
    }

    let res = [words[0]];
    let n = words.length;
    
    for (let i = 1; i < n; i++) {
        if (!compare(words[i], words[i-1])) {
            res.push(words[i]);
        }
    }
    return res;
};
// @lc code=end

