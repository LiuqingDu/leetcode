/*
 * @lc app=leetcode.cn id=917 lang=javascript
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reverseOnlyLetters = function(s) {

    let isLetter = function(c) {
        let t = c.charCodeAt(0), a = "a".charCodeAt(0), z = "z".charCodeAt(0), A = "A".charCodeAt(0), Z = "Z".charCodeAt(0);
        return (t >= a && t <= z) || (t >= A && t <= Z);
    }

    let cs = s.split("");
    let n = s.length;
    for (let i = 0, j = n - 1; i < j; ) {
        while (i < j && !isLetter(cs[i])) {
            i++;
        }

        while (i < j && !isLetter(cs[j])) {
            j--;
        }

        if (i < j) {
            let t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
        }

        i++;
        j--;
    }

    return cs.join("");
};
// @lc code=end

