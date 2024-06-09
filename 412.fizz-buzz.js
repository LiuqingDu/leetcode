/*
 * @lc app=leetcode.cn id=412 lang=javascript
 *
 * [412] Fizz Buzz
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function(n) {
    let res = []
    for (let i = 1; i <= n; i++) {
        let s = "";
        if (i % 3 === 0) {
            s += "Fizz";
        }
        if (i % 5 === 0) {
            s += "Buzz";
        }
        if (s.length === 0) {
            s += i;
        }
        res[i - 1] = s;
    }
    return res;

};
// @lc code=end

