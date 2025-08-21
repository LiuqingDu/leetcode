/*
 * @lc app=leetcode.cn id=2129 lang=javascript
 *
 * [2129] 将标题首字母大写
 */

// @lc code=start
/**
 * @param {string} title
 * @return {string}
 */
var capitalizeTitle = function(title) {
    return title
        .split(' ')
        .map(word => {
            if (word.length <= 2) {
                return word.toLowerCase();
            }
            return word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
        })
        .join(' ');
};
// @lc code=end

