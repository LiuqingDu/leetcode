/*
 * @lc app=leetcode.cn id=3386 lang=java
 *
 * [3386] 按下时间最长的按钮
 */

// @lc code=start
class Solution {
    public int buttonWithLongestTime(int[][] events) {
        
        int idx = events[0][0];
        int maxDiff = events[0][1];
        for (int i = 1; i < events.length; i++) {
            int[] p = events[i - 1];
            int[] q = events[i];
            int d = q[1] - p[1];
            if (d > maxDiff || d == maxDiff && q[0] < idx) {
                idx = q[0];
                maxDiff = d;
            }
        }
        return idx;

    }
}
// @lc code=end

