/*
 * @lc app=leetcode.cn id=1414 lang=javascript
 *
 * [1414] 和为 K 的最少斐波那契数字数目
 */

// @lc code=start
/**
 * @param {number} k
 * @return {number}
 */
var findMinFibonacciNumbers = function(k) {
    
    // 1. 初始化斐波那契数列
    const fib = [1, 1];
    
    // 生成所有小于等于 k 的斐波那契数
    while (true) {
        const nextFib = fib[fib.length - 1] + fib[fib.length - 2];
        if (nextFib > k) break;
        fib.push(nextFib);
    }
    
    // 2. 从大到小进行贪心选择
    let count = 0;
    
    // 当 k 还大于 0 时，不断尝试用最大的斐波那契数去减
    while (k > 0) {
        const currentFib = fib.pop(); // 弹出当前最大的斐波那契数
        
        if (k >= currentFib) {
            k -= currentFib; // 减去它
            count++;        // 计数加 1
        }
    }
    
    return count;
};
// @lc code=end

