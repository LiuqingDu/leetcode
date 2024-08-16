/*
 * @lc app=leetcode.cn id=824 lang=javascript
 *
 * [824] 山羊拉丁文
 */

// @lc code=start
/**
 * @param {string} sentence
 * @return {string}
 */
var toGoatLatin = function(sentence) {
    let n = sentence.length;
    let res = "";
    let prefix = "a";

    let i = 0;
    while (i < n) {
        let j = i;
        while (j < n && sentence.charAt(j) !== " ") {
            j++;
        }

        if ("aeiouAEIOU".indexOf(sentence[i]) >= 0) {
            res += sentence.substring(i, j);
        } else {
            res += sentence.substring(i + 1, j);
            res += sentence[i];
        }
        res += "ma";
        res += prefix;
        prefix += "a";
        i = j + 1;
        if (i < n) {
            res += " ";
        }
    }
    return res;
};
// @lc code=end

