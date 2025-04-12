/*
 * @lc app=leetcode.cn id=1507 lang=javascript
 *
 * [1507] 转变日期格式
 */

// @lc code=start
/**
 * @param {string} date
 * @return {string}
 */
var reformatDate = function(date) {
  const months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", 
    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

    const monthMap = {};
    for (let i = 0; i < months.length; i++) {
    monthMap[months[i]] = (i + 1).toString().padStart(2, '0');
    }

    const parts = date.split(" ");
    const day = parts[0].slice(0, -2).padStart(2, '0');
    const month = monthMap[parts[1]];
    const year = parts[2];

    return `${year}-${month}-${day}`;
};
// @lc code=end

