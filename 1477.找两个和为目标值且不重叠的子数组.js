/*
 * @lc app=leetcode.cn id=1477 lang=javascript
 *
 * [1477] 找两个和为目标值且不重叠的子数组
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number} target
 * @return {number}
 */
var minSumOfLengths = function(arr, target) {
    
    const pos = new Map([[0, -1]]);
    const n = arr.length;
    let s = 0, ans = n + 1, minL = n;
    for (let i = 0; i < n; i++) {
        s += arr[i];
        if (pos.has(s - target)) {
            const j = pos.get(s - target), length = i - j;
            ans = Math.min(ans, length + (j === -1 ? n : arr[j]));
            minL = Math.min(minL, length);
        }
        arr[i] = minL;
        pos.set(s, i);
    }
    return ans === n + 1 ? -1 : ans;

};
// @lc code=end

