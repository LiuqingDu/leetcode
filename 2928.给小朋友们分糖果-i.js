/*
 * @lc app=leetcode.cn id=2928 lang=javascript
 *
 * [2928] 给小朋友们分糖果 I
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} limit
 * @return {number}
 */
var distributeCandies = function(n, limit) {
  let count = 0;

  // 第一个小朋友
  for (let a = 0; a <= limit; a++) {
    // 第二个小朋友
    for (let b = 0; b <= limit; b++) {
      const c = n - a - b; // 第三个小朋友

      if (c >= 0 && c <= limit) {
        count++;
      }
    }
  }

  return count;
};
// @lc code=end

