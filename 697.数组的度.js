/*
 * @lc app=leetcode.cn id=697 lang=javascript
 *
 * [697] 数组的度
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findShortestSubArray = function(nums) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        if (map.has(nums[i])) {
            map.get(nums[i])[0]++;
            map.get(nums[i])[2] = i;
        } else {
            map.set(nums[i], [1, i, i]);
        }
    }

    let maxCount = 0, minLen = 0;
    for (let arr of map.values()) {
        if (maxCount < arr[0]) {
            maxCount = arr[0];
            minLen = arr[2] - arr[1] + 1;
        } else if (maxCount === arr[0]) {
            minLen = Math.min(minLen, arr[2] - arr[1] + 1);
        }
    }
    return minLen;
};
// @lc code=end

