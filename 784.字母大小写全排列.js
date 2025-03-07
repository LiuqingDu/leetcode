/*
 * @lc app=leetcode.cn id=784 lang=javascript
 *
 * [784] 字母大小写全排列
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[]}
 */
var letterCasePermutation = function(s) {
    let res = [];
    
    let dfs = function(arr, pos) {
        while (pos < arr.length && !isNaN(arr[pos])) {
            pos++;
        }
        if (pos === arr.length) {
            res.push(arr.join(''));
            return;
        }
        arr[pos] = String.fromCharCode(arr[pos].charCodeAt(0) ^ 32);
        dfs(arr, pos + 1);
        arr[pos] = String.fromCharCode(arr[pos].charCodeAt(0) ^ 32);
        dfs(arr, pos + 1);
    }

    dfs(s.split(''), 0);
    return res;
};
// @lc code=end

