/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    // 最终状态是剩下的区间互不相交，当然删除到只剩一个就可以了，
    // 但题目要求删除最少，那么也就是剩下的要足够多，在区间不重叠的情况下
    // 还要剩余最多，那么剩下的应当是尽量小的区间
    // 要足够小那么就要一个区间尽早地结束，
    // 也可以这么理解：假设已经求出了最多的不重叠区间，那么这里第一个区间
    // 放在原先重叠区间里，它的左侧必定没有一个完整的区间，也就是说，它应该是
    // 第一个结束的区间，否则它左侧的那个完整区间应当是第一个不重叠区间。
    // 如果选择end1最小的那一个区间，这个区间就是[0, end1]之间最小的完整区间，然后把跟这个区间
    // 重叠的区间都删掉，这样就保证了[0, end1]之间只有这一个不重叠区间了，
    // 然后从end1之后开始继续寻找一个start2在end1之后，且end2最小的区间，
    // 以此类推，最终剩下的这些end1，end2区间就是数量最多的不重叠区间，
    // 被删掉的区间就是所求的结果
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 所有区间按照end排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        // 找到第一个区间的end
        int right = intervals[0][1];
        // 至少已经有一个区间了
        int res = 1;
        
        // 从第二个区间开始遍历，每次遇到的第一个比前一个【不重叠区间的end】
        // 大或者等于的（新的区间在上一个不重叠区间的右侧）区间时，
        // 把这个区间当作一个不重叠区域，然后right指向这个区域的end
        // 同时计数，计数结果表示有多少个不重叠区间
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                res++;
                right = intervals[i][1];
            }
        }

        // 总数减去不重叠区域的最大值，就是最终结果
        return n - res;

    }
}
// @lc code=end

