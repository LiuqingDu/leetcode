/*
 * @lc app=leetcode.cn id=1360 lang=java
 *
 * [1360] 日期之间隔几天
 */

// @lc code=start
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getDays(date1) - getDays(date2));
    }

    private int getDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int days = 0;

        // 加年份天数
        for (int y = 1971; y < year; y++) {
            days += isLeap(y) ? 366 : 365;
        }

        // 加月份天数
        int[] monthDays = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        for (int m = 1; m < month; m++) {
            days += monthDays[m - 1];
            // 闰年的二月多一天
            if (m == 2 && isLeap(year)) {
                days++;
            }
        }

        // 加日期
        days += day;
        return days;

    }

    private boolean isLeap(int year) {
        return year % 400 == 0 || 
              (year % 4 == 0 && year % 100 != 0);
    }
}
// @lc code=end

