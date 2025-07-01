/*
 * @lc app=leetcode.cn id=826 lang=java
 *
 * [826] 安排工作以达到最大收益
 */

// @lc code=start
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // 把工作按照难度排序, 把工人按能力排序
        // 对于每个工人依次遍历他能执行的工作并记录他最大收益, 直到遇到不能执行的工作为止
        // 然后累加所有工人的最大收益
        
        // 将工作难度和收益打包成一个二维数组
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i]; // 工作难度
            jobs[i][1] = profit[i]; // 工作收益
        }
        // 按照工作难度从小到大排序
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        // 按照工作能力从小到大排序
        Arrays.sort(worker);
        int maxProfit = 0; // 最大收益
        int jobIndex = 0; // 当前工作索引
        int maxJobProfit = 0; // 当前最大工作收益
        for (int w : worker) {
            // 遍历每个工人
            // 找到工人能完成的最大工作收益
            while (jobIndex < n && jobs[jobIndex][0] <= w) {
                // 如果工作难度小于等于工人能力，则更新最大工作收益
                maxJobProfit = Math.max(maxJobProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            // 将工人能完成的最大工作收益加到总收益中
            maxProfit += maxJobProfit;
        }
        return maxProfit; // 返回最大收益
    }
}
// @lc code=end

