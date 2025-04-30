/*
 * @lc app=leetcode.cn id=1629 lang=java
 *
 * [1629] 按键持续时间最长的键
 */

// @lc code=start
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] cs = keysPressed.toCharArray();
        char res = cs[0];
        int pre = releaseTimes[0];
        int n = releaseTimes.length;
        for (int i = 1; i < n; i++) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (diff > pre) {
                pre = diff;
                res = cs[i];
            }
            if (diff == pre && res < cs[i]) {
                res = cs[i];
            }
        }
        return res;
    }
}
// @lc code=end

