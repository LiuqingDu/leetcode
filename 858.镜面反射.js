/*
 * @lc app=leetcode.cn id=858 lang=javascript
 *
 * [858] 镜面反射
 */

// @lc code=start
/**
 * @param {number} p
 * @param {number} q
 * @return {number}
 */
var mirrorReflection = function(p, q) {
    for (let n = 1;; n++) {
        const x = n * q;
        if (x % p === 0) {
            if (n % 2 === 0) {
                return 2; // 接收器在右侧
            } else {
                return (x / p) % 2 === 1 ? 1 : 0; // 接收器在左侧或上方
            }
        }
    }
};
// @lc code=end

