/*
 * @lc app=leetcode.cn id=3168 lang=javascript
 *
 * [3168] 候诊室中的最少椅子数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var minimumChairs = function(s) {
    let res = 0;
    let cnt = 0;
    
    for (let c of s) {
        if (c === "E") {
            cnt++;
            res = Math.max(res, cnt);
        } else {
            cnt--;
        }
    }
    return res;
};
// @lc code=end

