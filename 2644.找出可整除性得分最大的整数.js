/*
 * @lc app=leetcode.cn id=2644 lang=javascript
 *
 * [2644] 找出可整除性得分最大的整数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number[]} divisors
 * @return {number}
 */
var maxDivScore = function(nums, divisors) {
    cnt = -1
    ans = 0

    for (let i = 0; i < divisors.length; i++) {
        tmp = 0
        for (let j = 0; j < nums.length; j++) {
            if (nums[j] % divisors[i] == 0) {
                tmp++
            }
        }

        if (tmp > cnt || (tmp == cnt && divisors[i] < ans)) {
            cnt = tmp
            ans = divisors[i]
        }
    }
    return ans
};
// @lc code=end

