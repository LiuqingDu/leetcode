/*
 * @lc app=leetcode.cn id=2600 lang=javascript
 *
 * [2600] K 件物品的最大和
 */

// @lc code=start
/**
 * @param {number} numOnes
 * @param {number} numZeros
 * @param {number} numNegOnes
 * @param {number} k
 * @return {number}
 */
var kItemsWithMaximumSum = function(numOnes, numZeros, numNegOnes, k) {
    if (k <= numOnes) {
        return k;
    } else if (k <= numOnes + numZeros) {
        return numOnes;
    } else {
        return numOnes - (k - numOnes - numZeros);
    }
};
// @lc code=end

