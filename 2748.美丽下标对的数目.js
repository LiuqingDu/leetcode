/*
 * @lc app=leetcode.cn id=2748 lang=javascript
 *
 * [2748] 美丽下标对的数目
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var countBeautifulPairs = function(nums) {
    let gcd = (a, b) => {
        return b === 0 ? a : gcd(b, a % b);
    }

    let res = 0, n = nums.length;
    for (let i = 0; i < n; i++) {
        while (nums[i] >= 10) {
            nums[i] = Math.floor(nums[i] / 10);
        }

        for (let j = i + 1; j < n; j++) {
            if (gcd(nums[i], nums[j] % 10) === 1) {
                res++;
            }
        }
    }
    return res;
};
// @lc code=end

