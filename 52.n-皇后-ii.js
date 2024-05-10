/*
 * @lc app=leetcode.cn id=52 lang=javascript
 *
 * [52] N 皇后 II
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function(n) {

    let backtrace = function(n, row, col, diag1, diag2) {
        if (n === row) {
            return 1;
        }

        let count = 0;
        for (let i = 0; i < n; i++) {
            if (col.has(i)) {
                continue;
            }
            let d1 = row - i;
            if (diag1.has(d1)) {
                continue;
            }
            let d2 = row + i;
            if (diag2.has(d2)) {
                continue;
            }
            col.add(i);
            diag1.add(d1);
            diag2.add(d2);
            count += backtrace(n, row + 1, col, diag1, diag2);
            diag2.delete(d2);
            diag1.delete(d1);
            col.delete(i);
        }
        return count;
    }

    let col = new Set();
    let diag1 = new Set();
    let diag2 = new Set();

    return backtrace(n, 0, col, diag1, diag2);

};
// @lc code=end

