/*
 * @lc app=leetcode.cn id=347 lang=javascript
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    let map = new Map();
    for (n of nums) {
        map.set(n, (map.get(n) || 0) + 1);
    }

    let arr = Array.from(new Array(nums.length + 1), () => [])
    for (let [k, v] of map.entries()) {
        arr[v].push(k);
    }

    let res = [];
    for (let i = arr.length - 1; i >= 0; i--) {
        for (let j = 0; j < arr[i].length; j++) {
            if (res.length < k) {
                res.push(arr[i][j]);
            }
        }
    }
    return res;
};
// @lc code=end

