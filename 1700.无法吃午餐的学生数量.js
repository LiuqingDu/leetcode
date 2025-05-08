/*
 * @lc app=leetcode.cn id=1700 lang=javascript
 *
 * [1700] 无法吃午餐的学生数量
 */

// @lc code=start
/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {
    let sum = students.reduce((pre, cur) => pre + cur);
    // a 相当于有多少个 0
    let a = students.length - sum;
    // b 就是有多少个 1
    let b = sum;

    for (let sand of sandwiches) {
        if (sand === 0) {
            a--;
            if (a === -1) {
                break;
            }
        } else {
            b--;
            if (b === -1) {
                break;
            }
        }
    }
    return Math.max(a, b);
};
// @lc code=end

