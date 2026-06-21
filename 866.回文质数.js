/*
 * @lc app=leetcode.cn id=866 lang=javascript
 *
 * [866] 回文质数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var primePalindrome = function(n) {
    
    while (true) {
        // 核心剪枝：跳过偶数长度的回文数区间
        // 4位数区间：1000 ~ 9999
        if (n > 11 && n >= 1000 && n <= 9999) {
            n = 10000; // 直接跳到5位数
        }
        // 6位数区间：100,000 ~ 999,999
        if (n >= 100000 && n <= 999999) {
            n = 1000000; // 直接跳到7位数
        }
        // 8位数区间：10,000,000 ~ 99,999,999
        if (n >= 10000000 && n <= 99999999) {
            n = 100000000; // 直接跳到9位数
        }

        // 先判断回文，再判断质数
        if (isPalindrome(n) && isPrime(n)) {
            return n;
        }
        
        n++;
    }
};

// 1. 判断是否是回文数
function isPalindrome(num) {
    let original = num;
    let reversed = 0;
    while (num > 0) {
        reversed = reversed * 10 + (num % 10);
        num = Math.floor(num / 10); // JS 的除法带小数，需要向下取整
    }
    return original === reversed;
}

// 2. 判断是否是质数
function isPrime(num) {
    if (num < 2) return false;
    // 只需要判断到根号 num 即可
    for (let i = 2; i * i <= num; i++) {
        if (num % i === 0) {
            return false;
        }
    }
    return true;
}
// @lc code=end

