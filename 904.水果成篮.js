/*
 * @lc app=leetcode.cn id=904 lang=javascript
 *
 * [904] 水果成篮
 */

// @lc code=start
/**
 * @param {number[]} fruits
 * @return {number}
 */
var totalFruit = function(fruits) {
    
    const n = fruits.length;
    const cnt = new Map();

    let left = 0, ans = 0;
    for (let right = 0; right < n; ++right) {
        cnt.set(fruits[right], (cnt.get(fruits[right]) || 0) + 1);
        while (cnt.size > 2) {
            cnt.set(fruits[left], cnt.get(fruits[left]) - 1);
            if (cnt.get(fruits[left]) == 0) {
                cnt.delete(fruits[left]);
            }
            ++left;
        }
        ans = Math.max(ans, right - left + 1);
    }
    return ans;

};
// @lc code=end

