/*
 * @lc app=leetcode.cn id=3477 lang=javascript
 *
 * [3477] 水果成篮 II
 */

// @lc code=start
/**
 * @param {number[]} fruits
 * @param {number[]} baskets
 * @return {number}
 */
var numOfUnplacedFruits = function(fruits, baskets) {
    
    let count = 0;
    const n = baskets.length;
    for (const fruit of fruits) {
        let unset = 1;
        for (let i = 0; i < n; i++) {
            if (fruit <= baskets[i]) {
                baskets[i] = 0;
                unset = 0;
                break;
            }
        }
        count += unset;
    }
    return count;

};
// @lc code=end

