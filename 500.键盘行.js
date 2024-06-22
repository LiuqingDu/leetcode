/*
 * @lc app=leetcode.cn id=500 lang=javascript
 *
 * [500] 键盘行
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(words) {
    let res = [];
    let rowIndex = "12210111011122000010020202";
    for (let word of words) {
        let valid = true;
        let c = rowIndex.charAt(word.toLowerCase().charCodeAt(0) - "a".charCodeAt(0));
        for (let i = 1; i < word.length; i++) {
            if (rowIndex.charAt(word.toLowerCase().charCodeAt(i) - "a".charCodeAt(0)) != c) {
                valid = false;
                break;
            }
        }
        if (valid) {
            res.push(word);
        }
    }
    return res;
};
// @lc code=end

