/*
 * @lc app=leetcode.cn id=739 lang=javascript
 *
 * [739] 每日温度
 */

// @lc code=start
/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function(temperatures) {
    
    let n = temperatures.length;
    let stack = [];
    let res = Array(n);

    for (let i = n - 1; i >= 0; i--) {
        while (stack.length && temperatures[stack[stack.length - 1]] <= temperatures[i]) {
            stack.pop();
        }
        if (stack.length) {
            res[i] = stack[stack.length - 1] - i;
        } else {
            res[i] = 0;
        }
        stack.push(i);
    }

    return res;

};
// @lc code=end

