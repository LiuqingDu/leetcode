/*
 * @lc app=leetcode.cn id=1447 lang=javascript
 *
 * [1447] 最简分数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var simplifiedFractions = function(n) {
    
    // 最大公约数
    function gcd(a, b) {
        while (b !== 0) {
            let t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    
    let res = [];

    for (let b = 2; b <= n; b++) {      // 分母
        for (let a = 1; a < b; a++) {   // 分子
            if (gcd(a, b) === 1) {
                res.push(a + "/" + b);
            }
        }
    }

    return res;
};
// @lc code=end

