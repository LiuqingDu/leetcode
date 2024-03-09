/*
 * @lc app=leetcode.cn id=131 lang=javascript
 *
 * [131] 分割回文串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {

    let res = [];
    let n = s.length;
    let dp = Array.from(Array(n), () => Array(n).fill(false));

    for (let right = 0; right < n; right++) {
        for (let left = 0; left <= right; left++) {
            if (s.charAt(left) === s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                dp[left][right] = true;
            }
        }
    }
    
    let backtrack = function(s, i, path) {
        if (i === s.length) {
            res.push([...path]);
            return;
        }

        for (let j = i; j < s.length; j++) {
            if (dp[i][j]) {
                path.push(s.substring(i, j + 1));
                backtrack(s, j + 1, path);
                path.pop();
            }
        }
    }

    backtrack(s, 0, []);

    return res;

};
// @lc code=end

