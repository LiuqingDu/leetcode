/*
 * @lc app=leetcode.cn id=1031 lang=javascript
 *
 * [1031] 两个无重叠子数组的最大和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} firstLen
 * @param {number} secondLen
 * @return {number}
 */
var maxSumTwoNoOverlap = function(nums, firstLen, secondLen) {
    
    return Math.max(help(nums, firstLen, secondLen), help(nums, secondLen, firstLen));
};

function help(nums, firstLen, secondLen) {
    let suml = nums.slice(0, firstLen).reduce((acc, val) => acc + val, 0);
    let maxSumL = suml;
    let sumr = nums.slice(firstLen, firstLen + secondLen).reduce((acc, val) => acc + val, 0);
    let res = maxSumL + sumr;
    for (let i = firstLen + secondLen, j = firstLen; i < nums.length; i++, j++) {
        suml += nums[j] - nums[j - firstLen];
        maxSumL = Math.max(maxSumL, suml);
        sumr += nums[i] - nums[i - secondLen];
        res = Math.max(res, maxSumL + sumr);
    }
    return res;
}

// @lc code=end

