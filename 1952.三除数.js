/*
 * @lc app=leetcode.cn id=1952 lang=javascript
 *
 * [1952] 三除数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isThree = function(n) {
    let isPrime = function(num) {
        if (num < 2) return false;

        for (let i = 2; i * i <= num; i++) {
            if (num % i === 0) return false;
        }

        return true;
    }
    
    let sqrt = Math.sqrt(n);

    if (sqrt % 1 !== 0) return false;

    return isPrime(sqrt);

};
// @lc code=end

