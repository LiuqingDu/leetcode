/*
 * @lc app=leetcode.cn id=1436 lang=javascript
 *
 * [1436] 旅行终点站
 */

// @lc code=start
/**
 * @param {string[][]} paths
 * @return {string}
 */
var destCity = function(paths) {
    const setA = new Set();
    const setB = new Set();
    for (const [a, b] of paths) {
        setB.delete(a); // a 一定不是答案
        if (!setA.has(b)) { // b 有可能是答案
            setB.add(b);
        }
        setA.add(a);
    }
    return [...setB][0];
};
// @lc code=end

