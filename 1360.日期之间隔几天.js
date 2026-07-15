/*
 * @lc app=leetcode.cn id=1360 lang=javascript
 *
 * [1360] 日期之间隔几天
 */

// @lc code=start
/**
 * @param {string} date1
 * @param {string} date2
 * @return {number}
 */
var daysBetweenDates = function(date1, date2) {
    return Math.abs(getDays(date1) - getDays(date2));
};

function getDays(date) {
    let year = Number(date.substring(0, 4));
    let month = Number(date.substring(5, 7));
    let day = Number(date.substring(8, 10));

    let days = 0;

    // 计算之前年份的天数
    for (let y = 1971; y < year; y++) {
        days += isLeap(y) ? 366 : 365;
    }

    // 每个月天数
    let monthDays = [
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    ];

    // 计算之前月份的天数
    for (let m = 1; m < month; m++) {
        days += monthDays[m - 1];

        // 闰年的2月多一天
        if (m === 2 && isLeap(year)) {
            days++;
        }
    }

    // 加当前日期
    days += day;

    return days;
}

function isLeap(year) {
    return year % 400 === 0 || 
          (year % 4 === 0 && year % 100 !== 0);
};
// @lc code=end

