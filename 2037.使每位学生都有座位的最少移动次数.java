/*
 * @lc app=leetcode.cn id=2037 lang=java
 *
 * [2037] 使每位学生都有座位的最少移动次数
 */

// @lc code=start
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        // 将座位和学生数组排序
        // 排序后同一个下标的学生和座位匹配
        // 计算每个学生到对应座位的距离之和
        // 因为已经排好序了, 第一个学生去第二个座位且第二个学生去第一个座位并不会减少移动次数
        // 还有可能增加
        // 比如座位是 [1, 3], 学生是 [2, 4]
        // 对应去同下标的座位, 总次数是 2
        // 如果交换, 则总次数是 4
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }
}
// @lc code=end

