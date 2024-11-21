/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        // 对于每一个区间的终点，需要在所有起点中找到比它大的最小的那个
        // 如果把区间按照起点排序，那么就是先取出一个区间终点，
        // 然后在排序的起点中找到它右边那个位置，可以用二分查找
        // 题目最后要返回比它大一点的区间的索引
        // 所以需要按起点排序，并且对每一个起点还要保存它的索引

        int n = intervals.length;

        // 存储起始点和它的原始索引
        int[][] startPoints = new int[n][2];
        for (int i = 0; i < n; i++) {
            startPoints[i] = new int[]{intervals[i][0], i};
        }

        // 按起始点排序
        Arrays.sort(startPoints, (a, b) -> Integer.compare(a[0], b[0]));

        // 结果数组
        int[] result = new int[n];

        // 对每个区间进行二分查找
        for (int i = 0; i < n; i++) {
            int target = intervals[i][1]; // 当前区间的终点
            int index = binarySearch(startPoints, target); // 找右区间

            // 如果找到，返回索引；否则返回 -1
            result[i] = index == -1 ? -1 : startPoints[index][1];
        }

        return result;
    }
    
    // 二分查找：找第一个 >= target 的起始点
    private int binarySearch(int[][] startPoints, int target) {
        int left = 0, right = startPoints.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (startPoints[mid][0] >= target) {
                right = mid - 1; // 缩小范围找更小的
            } else {
                left = mid + 1; // 增大范围
            }
        }
        // 如果 left 没越界，返回它的索引；否则返回 -1
        return left < startPoints.length ? left : -1;
    }
}
// @lc code=end

