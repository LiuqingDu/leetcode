/*
 * @lc app=leetcode.cn id=345 lang=javascript
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    let set = new Set();
    let arr = ['a', 'e', 'i', 'o', 'u'];
    for (let c of arr) {
        set.add(c);
        set.add(c.toUpperCase());
    }

    let cs = s.split("");
    let l = 0, r = cs.length - 1;
    while (l < r) {
        if (set.has(cs[l]) && set.has(cs[r])) {
            let tmp = cs[l];
            cs[l] = cs[r];
            cs[r] = tmp;
            l++;
            r--;
        } else {
            if (!set.has(cs[l])) {
                l++;
            }
            if (!set.has(cs[r])) {
                r--;
            }
        }
    }

    return cs.join("");
};
// @lc code=end

