/*
 * @lc app=leetcode.cn id=1186 lang=javascript
 *
 * [1186] 删除一次得到子数组最大和
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var maximumSum = function(arr) {
    let dp0 = arr[0], dp1 = 0, res = arr[0];

    for (let i = 1; i < arr.length; i++) {
        dp1 = Math.max(dp0, dp1 + arr[i]);
        dp0 = Math.max(dp0, 0) + arr[i];
        res = Math.max(res, dp0, dp1);
    }

    return res;
};
// @lc code=end

