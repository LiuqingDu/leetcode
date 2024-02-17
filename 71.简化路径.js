/*
 * @lc app=leetcode.cn id=71 lang=javascript
 *
 * [71] 简化路径
 */

// @lc code=start
/**
 * @param {string} path
 * @return {string}
 */
var simplifyPath = function(path) {

    let queue = [];
    let n = path.length;

    for (let i = 0; i < n; i++) {
        while (i < n && path.charAt(i) === "/") {
            i++;
        }
        let j = i + 1;
        while (j < n && path.charAt(j) !== "/") {
            j++;
        }

        let p = path.substring(i, j);
        if (p === "..") {
            queue.pop();
        } else if (p !== "." && p.length) {
            queue.push(p);
        }
        i = j;
    }

    return "/" + queue.join("/");

};
// @lc code=end

