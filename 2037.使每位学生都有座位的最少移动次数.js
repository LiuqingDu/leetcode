/*
 * @lc app=leetcode.cn id=2037 lang=javascript
 *
 * [2037] 使每位学生都有座位的最少移动次数
 */

// @lc code=start
/**
 * @param {number[]} seats
 * @param {number[]} students
 * @return {number}
 */
var minMovesToSeat = function(seats, students) {
    seats.sort((a, b) => a - b);
    students.sort((a, b) => a - b);

    let moves = 0;
    for (let i = 0; i < seats.length; i++) {
        moves += Math.abs(seats[i] - students[i]);
    }
    
    return moves;
};
// @lc code=end

