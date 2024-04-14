/*
 * @lc app=leetcode.cn id=324 lang=javascript
 *
 * [324] 摆动排序 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var wiggleSort = function(nums) {

    let N = 5001;
    let bucket = Array(N).fill(0);

    for (let num of nums) {
        bucket[num]++;
    }
    
    let n = nums.length;
    let j = N - 1;
    for (let i = 1; i < n; i+=2) {
        while (bucket[j] === 0) {
            j--;
        }
        nums[i] = j;
        bucket[j]--;
    }
    for (let i = 0; i < n; i+=2) {
        while (bucket[j] === 0) {
            j--;
        }
        nums[i] = j;
        bucket[j]--;
    }

};
// @lc code=end

