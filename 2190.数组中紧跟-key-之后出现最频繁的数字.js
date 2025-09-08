/*
 * @lc app=leetcode.cn id=2190 lang=javascript
 *
 * [2190] 数组中紧跟 key 之后出现最频繁的数字
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} key
 * @return {number}
 */
var mostFrequent = function(nums, key) {
    const freqMap = new Map();
    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[i] === key) {
            freqMap.set(nums[i + 1], (freqMap.get(nums[i + 1]) || 0) + 1);
        }
    }
    let maxFreq = 0;
    let mostFrequentNum = -1;
    for (const [num, freq] of freqMap.entries()) {
        if (freq > maxFreq) {
            maxFreq = freq;
            mostFrequentNum = num;
        }
    }
    return mostFrequentNum;
};
// @lc code=end

