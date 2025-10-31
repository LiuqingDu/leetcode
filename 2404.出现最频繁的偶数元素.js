/*
 * @lc app=leetcode.cn id=2404 lang=javascript
 *
 * [2404] 出现最频繁的偶数元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var mostFrequentEven = function(nums) {
    const freqMap = new Map();
    for (const num of nums) {
        if (num % 2 === 0) {
            freqMap.set(num, (freqMap.get(num) || 0) + 1);
        }
    }

    let maxFreq = 0;
    let result = -1;

    for (const [num, freq] of freqMap.entries()) {
        if (freq > maxFreq || (freq === maxFreq && num < result)) {
            maxFreq = freq;
            result = num;
        }
    }

    return result;
};
// @lc code=end

