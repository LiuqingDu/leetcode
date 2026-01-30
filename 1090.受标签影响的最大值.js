/*
 * @lc app=leetcode.cn id=1090 lang=javascript
 *
 * [1090] 受标签影响的最大值
 */

// @lc code=start
/**
 * @param {number[]} values
 * @param {number[]} labels
 * @param {number} numWanted
 * @param {number} useLimit
 * @return {number}
 */
var largestValsFromLabels = function(values, labels, numWanted, useLimit) {
    const n = values.length;
    const idx = Array.from(Array(n), (_, i) => i);
    idx.sort((i, j) => values[j] - values[i]);

    let ans = 0, choose = 0;
    const cnt = {};
    for (let i = 0; i < n; i++) {
        const label = labels[idx[i]];
        if (cnt[label] === useLimit) {
            continue;
        }
        choose++;
        ans += values[idx[i]];
        cnt[label] = (cnt[label] || 0) + 1;
        if (choose === numWanted) {
            break;
        }
    }
    return ans;
};
// @lc code=end

