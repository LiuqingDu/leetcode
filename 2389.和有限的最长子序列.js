/*
 * @lc app=leetcode.cn id=2389 lang=javascript
 *
 * [2389] 和有限的最长子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number[]} queries
 * @return {number[]}
 */
var answerQueries = function(nums, queries) {
    
    nums.sort((a, b) => a - b); // 先排序 nums
    const n = nums.length;

    // 计算前缀和
    const prefix = new Array(n);
    prefix[0] = nums[0];
    for (let i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] + nums[i];
    }

    const answer = [];

    for (const q of queries) {
        let left = 0, right = n - 1;
        let idx = -1;
        // 二分查找前缀和中 <= q 的最大下标
        while (left <= right) {
            const mid = Math.floor((left + right) / 2);
            if (prefix[mid] <= q) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        answer.push(idx + 1); // 长度 = 下标+1
    }

    return answer;
};
// @lc code=end

