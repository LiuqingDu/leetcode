/*
 * @lc app=leetcode.cn id=799 lang=javascript
 *
 * [799] 香槟塔
 */

// @lc code=start
/**
 * @param {number} poured
 * @param {number} query_row
 * @param {number} query_glass
 * @return {number}
 */
var champagneTower = function(poured, query_row, query_glass) {
    let row = [poured];
    for (let i = 1; i <= query_row; i++) {
        const nextRow = new Array(i + 1).fill(0);
        for (let j = 0; j < i; j++) {
            const volume = row[j];
            if (volume > 1) {
                nextRow[j] += (volume - 1) / 2;
                nextRow[j + 1] += (volume - 1) / 2;
            }
        }
        row = nextRow;
    }
    return Math.min(1, row[query_glass]);
};
// @lc code=end

