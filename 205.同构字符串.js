/*
 * @lc app=leetcode.cn id=205 lang=javascript
 *
 * [205] 同构字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {

    let helper = function(a, b) {
        let map = new Map();
        let n = a.length;
        for (let i = 0; i < n; i++) {
            let c1 = a[i];
            let c2 = b[i];
            if (map.has(c1)) {
                if (map.get(c1) !== c2) {
                    return false;
                }
            } else {
                map.set(c1, c2);
            }
        }
        return true;
    }

    return helper(s, t) && helper(t, s);

};
// @lc code=end

