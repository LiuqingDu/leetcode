/*
 * @lc app=leetcode.cn id=2451 lang=javascript
 *
 * [2451] 差值数组不同的字符串
 */

// @lc code=start
/**
 * @param {string[]} words
 * @return {string}
 */
var oddString = function(words) {
    function get(word) {
        let diff = new Array(word.length-1);
        for (let i = 0; i + 1 < word.length; i++) {
            diff[i] = word.charCodeAt(i + 1) - word.charCodeAt(i);
        }
        return diff.toString();
    }

    let diff0 = get(words[0]);
    let diff1 = get(words[1]);
    if (diff0 === diff1) {
        for (let i = 2; i < words.length; i++) {
            if (diff0 != get(words[i])) {
                return words[i];
            }
        }
    }
    return diff0 === get(words[2]) ? words[1] : words[0]
};
// @lc code=end

