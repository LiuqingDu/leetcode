/*
 * @lc app=leetcode.cn id=1175 lang=javascript
 *
 * [1175] 质数排列
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var numPrimeArrangements = function(n) {
    
    const MOD = 1000000007n; // 使用 BigInt 防止溢出

    // 1. 判断是否为质数
    const isPrime = (num) => {
        if (num < 2) return false;
        for (let i = 2; i * i <= num; i++) {
            if (num % i === 0) return false;
        }
        return true;
    };

    // 2. 统计质数个数
    let primeCount = 0;
    for (let i = 1; i <= n; i++) {
        if (isPrime(i)) {
            primeCount++;
        }
    }

    // 3. 计算非质数个数
    let nonPrimeCount = n - primeCount;

    // 4. 计算阶乘并取模
    let ans = 1n;
    
    // 质数全排列
    for (let i = 1; i <= primeCount; i++) {
        ans = (ans * BigInt(i)) % MOD;
    }
    
    // 非质数全排列
    for (let i = 1; i <= nonPrimeCount; i++) {
        ans = (ans * BigInt(i)) % MOD;
    }

    return Number(ans);
};
// @lc code=end

