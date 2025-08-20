/*
 * @lc app=leetcode.cn id=869 lang=javascript
 *
 * [869] 重新排序得到 2 的幂
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var reorderedPowerOf2 = function(n) {

    const isPowerOfTwo = (n) => {
        return (n & (n - 1)) === 0;
    }
    
    const backtrack = (nums, idx, num) => {
        if (idx === nums.length) {
            return isPowerOfTwo(num);
        }
        for (let i = 0; i < nums.length; ++i) {
            if ((num === 0 && nums[i] === '0') || vis[i] || (i > 0 && !vis[i - 1] && nums[i] === nums[i - 1])) {
                continue;
            }
            vis[i] = true;
            if (backtrack(nums, idx + 1, num * 10 + nums[i].charCodeAt() - '0'.charCodeAt())) {
                return true;
            }
            vis[i] = false;
        }
        return false;
    }

    const nums = Array.from('' + n);
    nums.sort();
    const vis = new Array(nums.length).fill(false);
    return backtrack(nums, 0, 0);
};
// @lc code=end

