/*
 * @lc app=leetcode.cn id=853 lang=javascript
 *
 * [853] 车队
 */

// @lc code=start
/**
 * @param {number} target
 * @param {number[]} position
 * @param {number[]} speed
 * @return {number}
 */
var carFleet = function(target, position, speed) {
  const cars = position.map((pos, i) => [pos, (target - pos) / speed[i]]);
  cars.sort((a, b) => b[0] - a[0]);
  const stack = [];
  for (const [, time] of cars) {
    if (!stack.length || time > stack[stack.length - 1]) stack.push(time);
  }
  return stack.length;
};
// @lc code=end

