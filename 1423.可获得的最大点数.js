/*
 * @lc app=leetcode.cn id=1423 lang=javascript
 *
 * [1423] 可获得的最大点数
 */

// @lc code=start
/**
 * @param {number[]} cardPoints
 * @param {number} k
 * @return {number}
 */
var maxScore = function(cardPoints, k) {
    
    const n = cardPoints.length;
    const windowSize = n - k; // 剩余连续卡牌的窗口大小
    
    // 1. 计算数组总和，以及初始窗口（前 n - k 个元素）的和
    let totalSum = 0;
    let currentWindowSum = 0;
    
    for (let i = 0; i < n; i++) {
        totalSum += cardPoints[i];
        if (i < windowSize) {
            currentWindowSum += cardPoints[i];
        }
    }
    
    // 如果 k 等于数组长度，意味着要拿走所有的牌，直接返回总和
    if (windowSize === 0) return totalSum;
    
    // 2. 滑动窗口，寻找最小的窗口和
    let minWindowSum = currentWindowSum;
    for (let i = windowSize; i < n; i++) {
        // 窗口右移：加上新元素 cardPoints[i]，减去移出窗口的元素 cardPoints[i - windowSize]
        currentWindowSum += cardPoints[i] - cardPoints[i - windowSize];
        minWindowSum = Math.min(minWindowSum, currentWindowSum);
    }
    
    // 3. 最大点数 = 总和 - 最小窗口和
    return totalSum - minWindowSum;
};
// @lc code=end

