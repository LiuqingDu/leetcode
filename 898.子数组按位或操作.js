/*
 * @lc app=leetcode.cn id=898 lang=javascript
 *
 * [898] 子数组按位或操作
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var subarrayBitwiseORs = function(arr) {
    
    let ans = new Set();
    let cur = new Set();

    for (let x of arr) {
        let next = new Set();
        next.add(x);
        for (let y of cur) {
            next.add(y | x);
        }
        cur = next;
        for (let v of cur) {
            ans.add(v);
        }
    }

    return ans.size;
};
// @lc code=end

