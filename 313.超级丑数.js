/*
 * @lc app=leetcode.cn id=313 lang=javascript
 *
 * [313] 超级丑数
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[]} primes
 * @return {number}
 */
var nthSuperUglyNumber = function(n, primes) {
    let ugly = [1];
    let indices = new Array(primes.length).fill(0);
    
    for (let i = 1; i < n; i++) {
        let candidates = primes.map((prime, index) => prime * ugly[indices[index]]);
        let minUgly = Math.min(...candidates);
        ugly.push(minUgly);
        
        indices.forEach((_, index) => {
            if (primes[index] * ugly[indices[index]] === minUgly) {
                indices[index]++;
            }
        });
    }
    
    return ugly[n - 1];
};
// @lc code=end

