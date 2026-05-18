/*
 * @lc app=leetcode.cn id=1353 lang=java
 *
 * [1353] 最多可以参加的会议数目
 */

// @lc code=start
class Solution {
    public int maxEvents(int[][] events) {

        // 按开始时间排序
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // 小根堆：存结束时间
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        int n = events.length;

        int day = 1;
        int ans = 0;

        // 找最大结束时间
        int maxDay = 0;
        for (int[] e : events) {
            maxDay = Math.max(maxDay, e[1]);
        }

        // 枚举每一天
        for (day = 1; day <= maxDay; day++) {

            // 1. 加入今天开始的会议
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // 2. 删除已经过期的会议
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // 3. 参加结束最早的会议
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }
        }

        return ans;
    }
}
// @lc code=end

