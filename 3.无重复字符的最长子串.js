/*
 * @lc app=leetcode.cn id=3 lang=javascript
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {

  let l = s.length;
  let right = -1;
  let result = 0;

  let set = new Set();

  for (let i = 0; i < l; i++) {
    if (i !== 0) {
      set.delete(s.charAt(i - 1))
    }

    while (right + 1 < l && !set.has(s.charAt(right + 1))) {
      set.add(s.charAt(right + 1))
      right++;
    }

    result = Math.max(result, set.size)
  }
  return result
};

// @lc code=end
