/*
 * @lc app=leetcode.cn id=349 lang=javascript
 *
 * [349] 两个数组的交集
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {

    let arr = new Array(1001).fill(0);
    let res = [];
    for (let num of nums1) {
        arr[num] = 1;
    }
    for (let num of nums2) {
        arr[num]--;
        if (arr[num] === 0) {
            res.push(num);
        }
    }
    return res;
};
// @lc code=end

