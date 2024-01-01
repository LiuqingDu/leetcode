/*
 * @lc app=leetcode.cn id=698 lang=javascript
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var canPartitionKSubsets = function(nums, k) {

    if (nums.length < k) {
        return false;
    }

    let sum = 0;
    for (let i of nums) {
        sum+=i;
    }
    if (sum % k !== 0) {
        return false;
    }

    let target = sum / k;

    let backtrace = function(nums, start, bucket, target) {
        if (start === nums.length) {
            for (let b of bucket) {
                if (b !== target) {
                    return false;
                }
            }
            return true;
        }

        for (let i = 0; i < k; i++) {
            if (nums[start] + bucket[i] > target) {
                continue;
            }

            bucket[i] += nums[start];
            if (backtrace(nums, start + 1, bucket, target)) {
                return true;
            }
            bucket[i] -= nums[start];

            if (bucket[i] === 0) {
                return false;
            }
        }

        return false;

    }

    nums.sort((a, b) => b - a);

    return backtrace(nums, 0, Array(k).fill(0), target);

};
// @lc code=end

