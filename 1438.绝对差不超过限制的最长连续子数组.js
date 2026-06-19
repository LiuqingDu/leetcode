/*
 * @lc app=leetcode.cn id=1438 lang=javascript
 *
 * [1438] 绝对差不超过限制的最长连续子数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} limit
 * @return {number}
 */
var longestSubarray = function(nums, limit) {
    
    // maxQueue 维护窗口内最大值（单调递减）
    // minQueue 维护窗口内最小值（单调递增）
    const maxQueue = [];
    const minQueue = [];
    
    let left = 0;
    let maxLength = 0;
    
    for (let right = 0; right < nums.length; right++) {
        // 1. 维持 maxQueue 的单调递减性
        while (maxQueue.length > 0 && maxQueue[maxQueue.length - 1] < nums[right]) {
            maxQueue.pop();
        }
        maxQueue.push(nums[right]);
        
        // 2. 维持 minQueue 的单调递增性
        while (minQueue.length > 0 && minQueue[minQueue.length - 1] > nums[right]) {
            minQueue.pop();
        }
        minQueue.push(nums[right]);
        
        // 3. 检查当前窗口是否违反限制：最大值 - 最小值 > limit
        while (maxQueue[0] - minQueue[0] > limit) {
            // 如果左指针移出的元素是当前的最值，将其从队列头部弹出
            if (nums[left] === maxQueue[0]) {
                maxQueue.shift();
            }
            if (nums[left] === minQueue[0]) {
                minQueue.shift();
            }
            // 缩小窗口
            left++;
        }
        
        // 4. 更新最大长度
        maxLength = Math.max(maxLength, right - left + 1);
    }
    
    return maxLength;
};
// @lc code=end

