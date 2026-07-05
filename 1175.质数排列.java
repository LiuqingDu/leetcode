/*
 * @lc app=leetcode.cn id=1175 lang=java
 *
 * [1175] 质数排列
 */

// @lc code=start
class Solution {
    public int numPrimeArrangements(int n) {
        
        int mod = 1000000007;
        
        // 1. 统计 1 到 n 之间有多少个质数
        int primeCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        
        // 2. 非质数的个数
        int nonPrimeCount = n - primeCount;
        
        // 3. 计算结果：(质数个数的阶乘 * 非质数个数的阶乘) % mod
        long ans = 1;
        
        // 计算质数全排列
        for (int i = 1; i <= primeCount; i++) {
            ans = (ans * i) % mod;
        }
        
        // 计算非质数全排列
        for (int i = 1; i <= nonPrimeCount; i++) {
            ans = (ans * i) % mod;
        }
        
        return (int) ans;
    }

    // 判断是否为质数的辅助函数
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
// @lc code=end

