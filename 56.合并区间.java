/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {
        // 先按照区间左值排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        ArrayList<int[]> res = new ArrayList<int[]>();
        // 把第一个区间先加进去
        res.add(intervals[0]);

        // 从第二个区间开始，
        // 比较当前区间和已经加进去的最后一个区间
        // 如果有重叠，（最后一个区间的右值>=当前区间左值）
        // 则把最后一个区间的右值更新为最大值
        // 否则就是没重叠，直接把当前区间加进去
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = res.get(res.size() - 1);

            if (last[1] >= cur[0]) {
                last[1] = Math.max(last[1], cur[1]);
            } else {
                res.add(cur);
            }
        }
        return res.toArray(new int[0][0]);

    }
}
// @lc code=end

