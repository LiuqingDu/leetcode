/*
 * @lc app=leetcode.cn id=2899 lang=javascript
 *
 * [2899] 上一个遍历的整数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var lastVisitedIntegers = function(nums) {
    const seen = []; // 最近访问的正整数（最新的在前）
    const ans = [];
    let k = 0; // 连续 -1 的数量

    for (const num of nums) {
        if (num !== -1) {
            // 正整数，放到 seen 的最前面
            seen.unshift(num);
            k = 0; // 重置连续 -1
        } else {
            // 遇到 -1
            k++;
            if (k <= seen.length) {
                ans.push(seen[k - 1]);
            } else {
                ans.push(-1);
            }
        }
    }

    return ans;
};
// @lc code=end

