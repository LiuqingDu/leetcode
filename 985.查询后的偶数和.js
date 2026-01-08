/*
 * @lc app=leetcode.cn id=985 lang=javascript
 *
 * [985] 查询后的偶数和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {number[]}
 */
var sumEvenAfterQueries = function(nums, queries) {
    let m = queries.length, t = 0
    for (const x of nums) t += x % 2 == 0 ? x : 0
    const ans = new Array(m)
    for (let i = 0; i < m; i++) {
        const val = queries[i][0], idx = queries[i][1]
        if (nums[idx] % 2 == 0) t -= nums[idx]
        nums[idx] += val
        if (nums[idx] % 2 == 0) t += nums[idx]
        ans[i] = t;
    }
    return ans
};
// @lc code=end

