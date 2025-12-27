/*
 * @lc app=leetcode.cn id=2678 lang=javascript
 *
 * [2678] 老人的数目
 */

// @lc code=start
/**
 * @param {string[]} details
 * @return {number}
 */
var countSeniors = function(details) {
    let count = 0;
    for (let i = 0; i < details.length; i++) {
        if (parseInt(details[i].substring(11, 13)) > 60) {
            count++;
        }
    }
    return count;
};
// @lc code=end

