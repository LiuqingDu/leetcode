/*
 * @lc app=leetcode.cn id=421 lang=javascript
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaximumXOR = function(nums) {
    let max = 0;
    for (let n of nums) {
        max = Math.max(max, n);
    }
    
    let highBit = -1;
    while (max !== 0) {
        max >>= 1;
        highBit++;
    }

    let res = 0;
    let mask = 0;
    const set = new Set();

    for (let i = highBit; i >= 0; i--) {
        set.clear();
        mask |= 1 << i;
        let newRes = res | (1 << i);
        for (let n of nums) {
            n &= mask;
            if (set.has(newRes ^ n)) {
                res = newRes;
                break;
            }
            set.add(n);
        }
    }

    return res;
};
// @lc code=end

