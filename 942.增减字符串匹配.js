/*
 * @lc app=leetcode.cn id=942 lang=javascript
 *
 * [942] 增减字符串匹配
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number[]}
 */
var diStringMatch = function(s) {
    let res = [];
    let n = s.length;
    let l = 0;
    let r = n;
    
    for (let i = 0; i < n; i++) {
        if (s[i] === "I") {
            res.push(l);
            l++;
        } else {
            res.push(r);
            r--;
        }
    }
    res.push(l)
    return res;
};
// @lc code=end

