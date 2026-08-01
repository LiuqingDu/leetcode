/*
 * @lc app=leetcode.cn id=949 lang=java
 *
 * [949] 给定数字能组成的最大时间
 */

// @lc code=start
class Solution {
    public String largestTimeFromDigits(int[] arr) {
        
        int maxTime = -1;

        // 穷举 4 个数字的所有排列组合
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) continue;
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) continue;
                    for (int l = 0; l < 4; l++) {
                        if (l == i || l == j || l == k) continue;

                        int hours = arr[i] * 10 + arr[j];
                        int minutes = arr[k] * 10 + arr[l];

                        // 验证是否符合 24 小时制规则
                        if (hours < 24 && minutes < 60) {
                            int totalMinutes = hours * 60 + minutes;
                            maxTime = Math.max(maxTime, totalMinutes);
                        }
                    }
                }
            }
        }

        // 格式化输出为 "HH:MM"，若没有有效时间则返回空字符串
        return maxTime >= 0 ? String.format("%02d:%02d", maxTime / 60, maxTime % 60) : "";
    }
}
// @lc code=end

