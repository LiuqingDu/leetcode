/*
 * @lc app=leetcode.cn id=1356 lang=javascript
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number[]}
 */
var sortByBits = function(arr) {
    
    const getBitCount = (x) => {
        let res = 0;
        while (x) {
            res += x & 1;
            x >>>= 1;
        }
        return res;
    };
    
    const bitCounts = new Array(10001).fill(0);
    for (const x of arr) {
        bitCounts[x] = getBitCount(x);
    }
    
    arr.sort((x, y) => {
        if (bitCounts[x] !== bitCounts[y]) {
            return bitCounts[x] - bitCounts[y];
        }
        return x - y;
    });
    
    return arr;
};
// @lc code=end

