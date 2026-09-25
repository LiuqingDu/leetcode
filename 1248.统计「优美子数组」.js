/*
 * @lc app=leetcode.cn id=1248 lang=javascript
 *
 * [1248] 统计「优美子数组」
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numberOfSubarrays = function(nums, k) {
    let n = nums.length;
    let odd = [];
    let res = 0, cnt = 0;
    for (let i = 0; i < n; i++) {
        if ((nums[i] & 1) !== 0) {
            odd[++cnt] = i;
        }
    }
    odd[0] = -1;
    odd[++cnt] = n;
    for (let i = 1; i + k <= cnt; i++) {
        res += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
    }
    return res;
};
// @lc code=end

