/*
 * @lc app=leetcode.cn id=491 lang=javascript
 *
 * [491] 非递减子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var findSubsequences = function(nums) {
    const result = [];
    
    const backtrack = (start, temp) => {
        if (temp.length > 1) {
            result.push([...temp]);
        }
        const used = new Set();
        for (let i = start; i < nums.length; i++) {
            if (temp.length > 0 && nums[i] < temp[temp.length - 1]) {
                continue;
            }
            if (used.has(nums[i])) {
                continue;
            }
            temp.push(nums[i]);
            used.add(nums[i]);
            backtrack(i + 1, temp);
            temp.pop();
        }
    };

    backtrack(0, []);
    return result;
};
// @lc code=end

