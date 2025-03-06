/*
 * @lc app=leetcode.cn id=1299 lang=javascript
 *
 * [1299] 将每个元素替换为右侧最大元素
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number[]}
 */
var replaceElements = function(arr) {
    const n = arr.length;
    const ans = new Array(n);
    ans[n - 1] = -1;
    for (let i = n - 2; i >= 0; i--) {
        ans[i] = Math.max(ans[i + 1], arr[i + 1]);
    }
    return ans;
};
// @lc code=end

