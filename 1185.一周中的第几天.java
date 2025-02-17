/*
 * @lc app=leetcode.cn id=1185 lang=java
 *
 * [1185] 一周中的第几天
 */

// @lc code=start
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        // 题目是从 1971 年 1 月 1 日开始
        // 它前一天 1970 年 12 月 31 日是周四
        // 那么目标日期距离这个起点的天数由三部分组成:
        // （1）输入年份之前的年份的天数贡献；
        // （2）输入年份中，输入月份之前的月份的天数贡献；
        // （3）输入月份中的天数贡献。
        // 其中 (1) 和 (2) 还需要考虑闰年
        
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* 输入年份之前的年份的天数贡献 */
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* 输入年份中，输入月份之前的月份的天数贡献 */
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        /* 输入月份中的天数贡献 */
        days += day;
        return week[(days + 3) % 7];
    }
}
// @lc code=end

