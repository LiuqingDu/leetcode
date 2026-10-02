/*
 * @lc app=leetcode.cn id=1442 lang=javascript
 *
 * [1442] 形成两个异或相等数组的三元组数目
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number}
 */
var countTriplets = function(arr) {
    
    const n = arr.length;
    const s = [0];
    for (const num of arr) {
        s.push(s[s.length - 1] ^ num);
    }

    let ans = 0;
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            for (let k = j; k < n; k++) {
                if (s[i] === s[k + 1]) {
                    ans++;
                }
            }
        }
    }

    return ans;

};
// @lc code=end

