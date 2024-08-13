/*
 * @lc app=leetcode.cn id=804 lang=javascript
 *
 * [804] 唯一摩尔斯密码词
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {number}
 */
var uniqueMorseRepresentations = function(words) {
    const arr = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
    let set = new Set();
    for (let word of words) {
        let s = "";
        for (let c of word) {
            s += arr[c.charCodeAt(0) - 'a'.charCodeAt(0)];
        }
        set.add(s);
    }
    return set.size;
};
// @lc code=end

