/*
 * @lc app=leetcode.cn id=526 lang=javascript
 *
 * [526] 优美的排列
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var countArrangement = function(n) {
    
    let countBits = function(mask) {
        let count = 0;
        while (mask) {
            count++;
            mask &= (mask - 1);
        }
        return count;
    }
    
    let dfs = function(state, n, memo) {
        if (state === (1 << n) - 1) {
            return 1;
        }
        if (memo[state] !== -1) {
            return memo[state];
        }
    
        let result = 0;
        let position = countBits(state) + 1;
    
        for (let num = 1; num <= n; num++) {
            if ((state >> (num - 1) & 1) === 0) {
                if (position % num === 0 || num % position === 0) {
                    result += dfs(state | (1 << (num - 1)), n, memo);
                }
            }
        }
    
        memo[state] = result;
        return result;
    }

    let memo = new Array(1 << n).fill(-1);
    return dfs(0, n, memo);
};
// @lc code=end

