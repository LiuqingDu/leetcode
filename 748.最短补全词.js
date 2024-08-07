/*
 * @lc app=leetcode.cn id=748 lang=javascript
 *
 * [748] 最短补全词
 */

// @lc code=start
/**
 * @param {string} licensePlate
 * @param {string[]} words
 * @return {string}
 */
var shortestCompletingWord = function(licensePlate, words) {
    let isLetter = function(c) {
        let t = c.charCodeAt(0), a = "a".charCodeAt(0), z = "z".charCodeAt(0), A = "A".charCodeAt(0), Z = "Z".charCodeAt(0);
        return (t >= a && t <= z) || (t >= A && t <= Z);
    }
    let getCount = function(s) {
        let res = new Array(26).fill(0);
        for (let c of s) {
            if (isLetter(c)) {
                res[c.toLocaleLowerCase().charCodeAt(0) - 'a'.charCodeAt(0)]++;
            }
        }
        return res;
    }

    let target = getCount(licensePlate);
    let res = undefined;
    for (let word of words) {
        let count = getCount(word);
        let flag = true;
        for (let i = 0; i < 26; i++) {
            if (count[i] < target[i]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            if (res === undefined || res.length > word.length) {
                res = word;
            }
        }
    }
    return res;
};
// @lc code=end

