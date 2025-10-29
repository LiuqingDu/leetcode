/*
 * @lc app=leetcode.cn id=2383 lang=java
 *
 * [2383] 赢得比赛需要的最少训练时长
 */

// @lc code=start
class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = 0;
        for (int e : energy) {
            sum += e;
        }
        int trainingHours = initialEnergy > sum ? 0 : sum + 1 - initialEnergy;
        for (int e : experience) {
            if (initialExperience <= e) {
                trainingHours += 1 + (e - initialExperience);
                initialExperience = 2 * e + 1;
            } else {
                initialExperience += e;
            }
        }
        return trainingHours;
    }
}
// @lc code=end

