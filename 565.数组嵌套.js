/*
 * @lc app=leetcode.cn id=565 lang=javascript
 *
 * [565] 数组嵌套
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var arrayNesting = function(nums) {
    let res = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === -1) {
            continue;
        }

        let size = 0;
        let currentIndex = i;

        while (nums[currentIndex] !== -1) {
            let nextIndex = nums[currentIndex];
            nums[currentIndex] = -1;
            currentIndex = nextIndex;
            size++;
        }

        res = Math.max(res, size);
    }

    return res;
};
// @lc code=end

