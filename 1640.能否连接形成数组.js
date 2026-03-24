/*
 * @lc app=leetcode.cn id=1640 lang=javascript
 *
 * [1640] 能否连接形成数组
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @param {number[][]} pieces
 * @return {boolean}
 */
var canFormArray = function(arr, pieces) {
    const map = new Map();
    for (let piece of pieces) {
        map.set(piece[0], piece);
    }

    let i = 0;
    while (i < arr.length) {
        if (!map.has(arr[i])) {
            return false;
        }

        let piece = map.get(arr[i])
        for (let num of piece) {
            if (num !== arr[i]) {
                return false;
            }
            i++;
        }
    }
    return true;
};
// @lc code=end

