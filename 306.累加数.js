/*
 * @lc app=leetcode.cn id=306 lang=javascript
 *
 * [306] 累加数
 */

// @lc code=start
/**
 * @param {string} num
 * @return {boolean}
 */
var isAdditiveNumber = function(num) {

    let dfs = function(num, ind, path) {
        if (ind === num.length) {
            return path.length >= 3;
        }
        let max = num.charAt(ind) === '0' ? ind + 1 : num.length;
        let cur = 0;
        for (let i = ind; i < max; i++) {
            cur = cur * 10 + parseInt(num.charAt(i));
            if (path.length < 2 || path[path.length - 1] + path[path.length - 2] === cur) {
                path.push(cur);
                if (dfs(num, i + 1, path)) {
                    return true;
                }
                path.pop();
            }
        }
        return false;
    }

    return dfs(num, 0, []);
};
// @lc code=end

