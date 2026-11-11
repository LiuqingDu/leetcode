/*
 * @lc app=leetcode.cn id=1524 lang=javascript
 *
 * [1524] 和为奇数的子数组数目
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var numOfSubarrays = function(arr) {
    
    const MODULO = 1000000007;
    let odd = 0, even = 1;
    let subarrays = 0;
    let total = 0;
    
    for (const x of arr) {
        total += x;
        if (total % 2 === 0) {
            subarrays = (subarrays + odd) % MODULO;
            even++;
        } else {
            subarrays = (subarrays + even) % MODULO;
            odd++;
        }
    }
    
    return subarrays % MODULO;

};
// @lc code=end

