/*
 * @lc app=leetcode.cn id=957 lang=javascript
 *
 * [957] N 天后的牢房
 */

// @lc code=start
/**
 * @param {number[]} cells
 * @param {number} n
 * @return {number[]}
 */
var prisonAfterNDays = function(cells, n) {
    
    const seen = new Map();

    while (n > 0) {
        const state = cells.join('');
        // 当前状态以前出现过，说明进入循环
        if (seen.has(state)) {
            const cycle = seen.get(state) - n;
            n %= cycle;
        }

        // 记录：这个状态出现时，还剩多少天
        seen.set(state, n);

        if (n > 0) {
            n--;
            const next = new Array(8).fill(0);
            for (let i = 1; i < 7; i++) {
                next[i] = cells[i - 1] === cells[i + 1] ? 1 : 0;
            }
            cells = next;
        }
    }

    return cells;
};
// @lc code=end

