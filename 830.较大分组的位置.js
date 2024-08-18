/*
 * @lc app=leetcode.cn id=830 lang=javascript
 *
 * [830] 较大分组的位置
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number[][]}
 */
var largeGroupPositions = function(s) {
    let res = [];
    let n = s.length;
    let i = 0;
    while (i < n) {
        let j = i;
        while (j < n && s[j] === s[i]) {
            j++;
        }
        if (j - i >= 3) {
            res.push([i, j - 1]);
        }
        i = j;
    }

    return res;

};
// @lc code=end

