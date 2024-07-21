/*
 * @lc app=leetcode.cn id=661 lang=javascript
 *
 * [661] 图片平滑器
 */

// @lc code=start
/**
 * @param {number[][]} img
 * @return {number[][]}
 */
var imageSmoother = function(img) {
    let m = img.length, n = img[0].length;
    let sumArr = Array.from(Array(m + 1), () => Array(n + 1).fill(0));
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + img[i - 1][j - 1];
        }
    }
    let res = Array.from(Array(m), () => Array(n).fill(0));
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let x1 = Math.max(0, i - 1), y1 = Math.max(0, j - 1);
            let x2 = Math.min(m - 1, i + 1), y2 = Math.min(n - 1, j + 1);
            let count = (x2 - x1 + 1) * (y2 - y1 + 1);
            let sum = sumArr[x2 + 1][y2 + 1] - sumArr[x1 + 1 - 1][y2 + 1] - sumArr[x2 + 1][y1 + 1 - 1] + sumArr[x1 + 1 - 1][y1 + 1 - 1];
            res[i][j] = Math.floor(sum / count);
        }
    }
    return res;
};
// @lc code=end

