/*
 * @lc app=leetcode.cn id=541 lang=javascript
 *
 * [541] 反转字符串 II
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function(s, k) {
    let reverse = function(cs, l, r) {
        while (l < r) {
            let c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--; 
        }
    }

    let cs = Array.from(s);
    let n = cs.length;
    for (let l = 0; l < n; l = l + 2 * k) {
        let r = l + k - 1;
        reverse(cs, l, Math.min(r, n - 1));
    }
    return cs.join("");
};
// @lc code=end

