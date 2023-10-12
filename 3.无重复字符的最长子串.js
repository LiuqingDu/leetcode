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
var lengthOfLongestSubstring = function(s) {
    let n = s.length;
    if (n === 0) {
        return 0;
    }

    let set = new Set();
    let left = 0;
    let right = 0;
    let count = 0;
    let res = 0;

    // 窗口右边框向右移动
    while (right < n && left < n) {
        if (!set.has(s.charAt(right))) {
            set.add(s.charAt(right));
            count++;
            res = Math.max(count, res);
            right++;
        } else {
            // 遇到相同字符了，缩小左边框
            while (left <= right) {
                if (set.has(s.charAt(left))) {
                    set.delete(s.charAt(left));
                    count--;
                    left++;
                    break;
                } else {
                    count--;
                    left++;
                }
            }
        }
    }
    
    return res;

};
// @lc code=end

