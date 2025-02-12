/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // 要么走两点内部,要么走两点外部
        // 先把起点终点调整成起点在左边,终点是右边的那个
        // 然后遍历每段路程,看是属于外部的路还是两点内的路
        // 比较两段路程

        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }
}
// @lc code=end

