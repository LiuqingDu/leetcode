/*
 * @lc app=leetcode.cn id=2960 lang=java
 *
 * [2960] 统计已测试设备
 */

// @lc code=start
class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                res++;
                for (int j = i + 1; j < n; j++) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }
        return res;
    }
}
// @lc code=end

