/*
 * @lc app=leetcode.cn id=826 lang=javascript
 *
 * [826] 安排工作以达到最大收益
 */

// @lc code=start
/**
 * @param {number[]} difficulty
 * @param {number[]} profit
 * @param {number[]} worker
 * @return {number}
 */
var maxProfitAssignment = function(difficulty, profit, worker) {
    const jobs = difficulty.map((d, i) => [d, profit[i]]).sort((a, b) => a[0] - b[0]);
    worker.sort((a, b) => a - b);
    
    let maxProfit = 0;
    let maxJobProfit = 0;
    let jobIndex = 0;

    for (const w of worker) {
        while (jobIndex < jobs.length && jobs[jobIndex][0] <= w) {
            maxJobProfit = Math.max(maxJobProfit, jobs[jobIndex][1]);
            jobIndex++;
        }
        maxProfit += maxJobProfit;
    }

    return maxProfit;
};
// @lc code=end

