/*
 * @lc app=leetcode.cn id=2570 lang=javascript
 *
 * [2570] 合并两个二维数组 - 求和法
 */

// @lc code=start
/**
 * @param {number[][]} nums1
 * @param {number[][]} nums2
 * @return {number[][]}
 */
var mergeArrays = function(nums1, nums2) {
    let i = 0, j = 0;
    let res = [];

    while (i < nums1.length && j < nums2.length) {
        let [id1, val1] = nums1[i];
        let [id2, val2] = nums2[j];

        if (id1 === id2) {
            res.push([id1, val1 + val2]);
            i++;
            j++;
        } else if (id1 < id2) {
            res.push([id1, val1]);
            i++;
        } else {
            res.push([id2, val2]);
            j++;
        }
    }

    // 处理剩余
    while (i < nums1.length) {
        res.push(nums1[i++]);
    }

    while (j < nums2.length) {
        res.push(nums2[j++]);
    }

    return res;
};
// @lc code=end

