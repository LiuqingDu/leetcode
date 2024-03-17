/*
 * @lc app=leetcode.cn id=164 lang=javascript
 *
 * [164] 最大间距
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumGap = function(nums) {
    let n = nums.length;
    if (n <= 1) {
        return 0;
    }

    let min = Number.MAX_VALUE;
    let max = Number.MIN_VALUE;

    for (let num of nums) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }

    if (min === max) {
        return 0;
    }

    let bucketSize = Math.max(1, Math.floor((max - min) / (n - 1)));
    let bucketNum = Math.floor((max - min) / bucketSize + 1);

    let mins = Array(bucketNum).fill(Number.MAX_VALUE);
    let maxs = Array(bucketNum).fill(Number.MIN_VALUE);

    for (let num of nums) {
        let position = Math.floor((num - min) / bucketSize);
        mins[position] = Math.min(mins[position], num);
        maxs[position] = Math.max(maxs[position], num);
    }

    let res = 0;
    let preMax = maxs[0];

    for (let i = 1; i < bucketNum; i++) {
        if (maxs[i] === Number.MIN_VALUE) {
            continue;
        }
        res = Math.max(res, mins[i] - preMax);
        preMax = maxs[i];
    }

    return res;

};
// @lc code=end

