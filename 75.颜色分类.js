/*
 * @lc app=leetcode.cn id=75 lang=javascript
 *
 * [75] 颜色分类
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {

    let n = nums.length;
    let r = 0, w = 0, b = 0;
    let p = 0;

    while (p < n) {
        switch (nums[p]) {
            case 0:
                nums[r] = 0;
                r++;
            case 1:
                // 如果w=r-1, 说明是目前还没有一个w元素，且是case 0到这里的，
                // 那么这里因为没有w元素就不能填充
                if (w != r - 1) {
                    nums[w] = 1;
                }
                w++;
            case 2:
                if (b + 1 != w) {
                    nums[b] = 2;
                }
                b++;
        }
        p++;
    }

};
// @lc code=end

