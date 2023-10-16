/*
 * @lc app=leetcode.cn id=22 lang=javascript
 *
 * [22] 括号生成
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {

    let res = [];

    let left = 0, right = 0;
    
    let backtrace = function(left, right, n, str) {

        if (left > n || right > n || left < 0 || right < 0 || left < right) {
            return;
        }

        if (left === n && right === n) {
            res.push("" + str);
            return;
        }

        left++;
        str += "(";
        backtrace(left, right, n, str);
        str = str.substring(0, str.length - 1);
        left--;

        right++;
        str += ")";
        backtrace(left, right, n, str);
        str = str.substring(0, str.length - 1);
        right--;

        return;
    }

    backtrace(left, right, n, "");
    return res;

};
// @lc code=end

