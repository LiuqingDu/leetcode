/*
 * @lc app=leetcode.cn id=3375 lang=javascript
 *
 * [3375] 使数组的值全部为 K 的最少操作次数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function(nums, k) {
    
    const st = new Set();
    for (const x of nums) {
        if (x < k) {
            return -1;
        } else if (x > k) {
            st.add(x);
        }
    }
    return st.size;
};
// @lc code=end

