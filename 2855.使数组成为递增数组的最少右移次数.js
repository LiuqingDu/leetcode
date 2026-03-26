/*
 * @lc app=leetcode.cn id=2855 lang=javascript
 *
 * [2855] 使数组成为递增数组的最少右移次数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumRightShifts = function(nums) {
    
    const n = nums.length;
    let count = 0;   // 断点个数
    let index = -1;  // 断点位置

    for (let i = 0; i < n; i++) {
        let next = (i + 1) % n;
        if (nums[i] > nums[next]) {
            count++;
            index = i;
        }
    }

    // 情况1：已经递增
    if (count === 0) return 0;

    // 情况2：只有一个断点
    if (count === 1) {
        return n - (index + 1);
    }

    // 情况3：无法变成递增
    return -1;
};
// @lc code=end

