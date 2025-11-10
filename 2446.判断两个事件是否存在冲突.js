/*
 * @lc app=leetcode.cn id=2446 lang=javascript
 *
 * [2446] 判断两个事件是否存在冲突
 */

// @lc code=start
/**
 * @param {string[]} event1
 * @param {string[]} event2
 * @return {boolean}
 */
var haveConflict = function(event1, event2) {
    return !(event1[1] < event2[0] || event2[1] < event1[0]);
};
// @lc code=end

