/*
 * @lc app=leetcode.cn id=1952 lang=java
 *
 * [1952] 三除数
 */

// @lc code=start
class Solution {
    public boolean isThree(int n) {
        // 首先必定有除数 1 和他本身 n
        // 那么第三个除数只能是 n 的平方根, 且这个根是质数
        // 可以反证
        // 如果存在第三个除数,且除数不是平方根, 记为 m1
        // 那么必定存在 m2 使得 m1 * m2 = n
        // 那么 m1 和 m2 必定是 n 的除数, 且 m1 != m2
        // 所以 n 必定有超过三个除数

        // 开方，找是否存在一个质数 p，使得 p^2 == n
        int sqrt = (int) Math.sqrt(n);

        // 如果 n 不是完全平方数，肯定不行
        if (sqrt * sqrt != n) {
            return false;
        }

        // 判断 sqrt 是否是质数
        return isPrime(sqrt);
    }

    // 判断一个数是否是质数
    private boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
// @lc code=end

