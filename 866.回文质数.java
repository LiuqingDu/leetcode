/*
 * @lc app=leetcode.cn id=866 lang=java
 *
 * [866] 回文质数
 */

// @lc code=start
class Solution {
    public int primePalindrome(int n) {
        
        while (true) {
            // 核心剪枝：跳过偶数长度的回文数区间（除了11本身）
            // 4位数区间：1000 ~ 9999
            if (n > 11 && n >= 1000 && n <= 9999) {
                n = 10000; // 直接跳到5位数
            }
            // 6位数区间：100,000 ~ 999,999
            if (n >= 100000 && n <= 999999) {
                n = 1000000; // 直接跳到7位数
            }
            // 8位数区间：10,000,000 ~ 99,999,000
            if (n >= 10000000 && n <= 99999999) {
                n = 100000000; // 直接跳到9位数
            }

            // 先判断是不是回文（判断回文比判断质数快，先做快的）
            if (isPalindrome(n) && isPrime(n)) {
                return n;
            }
            
            n++;
        }
    }

    // 1. 判断是否是回文数
    private boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return original == reversed;
    }

    // 2. 判断是否是质数
    private boolean isPrime(int num) {
        if (num < 2) return false;
        // 只需要判断到根号 num 即可
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

