/*
 * @lc app=leetcode.cn id=386 lang=javascript
 *
 * [386] 字典序排数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
var lexicalOrder = function(n) {
    let res = [];
    for (let i = 0, j = 1; i < n; i++) {
        res.push(j);
        if (j * 10 <= n) {
            j *= 10;
        } else {
            while (j % 10 === 9 || j + 1 > n) {
                j = Math.floor(j / 10);
            }
            j++;
        }
    }

    return res;
};
// @lc code=end

