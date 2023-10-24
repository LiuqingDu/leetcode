/*
 * @lc app=leetcode.cn id=96 lang=javascript
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var numTrees = function(n) {

    let memo = [];
    for (let i = 0; i < n + 1; i++) {
        memo[i] = [];
    }

    let reversal = function(min, max) {
        let res = 0;

        if (min > max) {
            return 1;
        }

        if (memo[min][max]) {
            return memo[min][max];
        }

        for (let i = min; i <= max; i++) {
            let left = reversal(min, i - 1);
            let right = reversal(i + 1, max);
            res += left * right;
        }

        memo[min][max] = res;
        
        return res;

    }

    return reversal(1, n);
};
// @lc code=end

