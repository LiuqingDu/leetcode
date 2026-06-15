/*
 * @lc app=leetcode.cn id=1423 lang=java
 *
 * [1423] 可获得的最大点数
 */

// @lc code=start
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        // 剩余连续卡牌的窗口大小
        int windowSize = n - k;
        
        // 1. 计算整个数组的总和，以及初始窗口（前 n - k 个元素）的和
        int totalSum = 0;
        int currentWindowSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
            if (i < windowSize) {
                currentWindowSum += cardPoints[i];
            }
        }
        
        // 如果 k 等于数组长度，直接返回总和
        if (windowSize == 0) {
            return totalSum;
        }
        
        // 2. 开始滑动窗口，寻找最小的窗口和
        int minWindowSum = currentWindowSum;
        for (int i = windowSize; i < n; i++) {
            // 窗口向右移动：加上新进入窗口的元素，减去离开窗口的元素
            currentWindowSum += cardPoints[i] - cardPoints[i - windowSize];
            // 更新最小值
            minWindowSum = Math.min(minWindowSum, currentWindowSum);
        }
        
        // 3. 最大点数 = 总和 - 最小窗口和
        return totalSum - minWindowSum;
    }
}
// @lc code=end

