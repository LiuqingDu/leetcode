/*
 * @lc app=leetcode.cn id=3354 lang=javascript
 *
 * [3354] 使数组元素等于零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var countValidSelections = function(nums) {
    
    let count = 0, nonZeros = nums.filter(x => x > 0).length, n = nums.length;
    for (let i = 0; i < n; i++) {
        if (nums[i] === 0) {
            if (isValid([...nums], nonZeros, i, -1)) {
                count++;
            }
            if (isValid([...nums], nonZeros, i, 1)) {
                count++;
            }
        }
    }
    return count;
};


function isValid(nums, nonZeros, start, direction) {
    let curr = start;
    while (nonZeros > 0 && curr >= 0 && curr < nums.length) {
        if (nums[curr] > 0) {
            nums[curr]--;
            direction *= -1;
            if (nums[curr] === 0) {
                nonZeros--;
            }
        }
        curr += direction;
    }
    return nonZeros === 0;
}

// @lc code=end

