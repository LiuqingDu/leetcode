/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        // 指向res中下一个位置，用来往res里填充结果
        int ind = 0;
        // 指向intervals中要处理的区间
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[ind][0] = intervals[i][0];
            res[ind][1] = intervals[i][1];
            ind++;
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res[ind][0] = newInterval[0];
        res[ind][1] = newInterval[1];
        ind++;
        while (i < intervals.length) {
            res[ind][0] = intervals[i][0];
            res[ind][1] = intervals[i][1];
            ind++;
            i++;
        }

        return Arrays.copyOfRange(res, 0, ind);
    }
}
// @lc code=end

