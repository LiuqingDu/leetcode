/*
 * @lc app=leetcode.cn id=368 lang=javascript
 *
 * [368] 最大整除子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var largestDivisibleSubset = function(nums) {
    nums.sort((a, b) => a - b);
    let n = nums.length;
    let f = Array(n).fill(0);
    let g = Array(n).fill(0);

    for (let i = 0; i < n; i++) {
        let len = 1, prev = i;
        for (let j = 0; j < i; j++) {
            if (nums[i] % nums[j] === 0) {
                if (f[j] + 1 > len) {
                    len = f[j] + 1;
                    prev = j;
                }
            }
        }
        f[i] = len;
        g[i] = prev;
    }

    let max = -1, ind = -1;
    for (let i = 0; i < n; i++) {
        if (f[i] > max) {
            ind = i;
            max = f[i];
        }
    }

    let res = [];
    while (res.length !== max) {
        res.push(nums[ind]);
        ind = g[ind];
    }
    return res;
};
// @lc code=end

