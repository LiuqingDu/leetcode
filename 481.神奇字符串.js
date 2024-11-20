/*
 * @lc app=leetcode.cn id=481 lang=javascript
 *
 * [481] 神奇字符串
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var magicalString = function(n) {
    if (n === 0) return 0;
    if (n <= 3) return 1;

    let magical = [1, 2, 2];
    let head = 2;
    let countOnes = 1;

    while (magical.length < n) {
        let repeat = magical[head];
        let nextChar = magical[magical.length - 1] === 1 ? 2 : 1;

        for (let i = 0; i < repeat; i++) {
            magical.push(nextChar);
            if (nextChar === 1 && magical.length <= n) {
                countOnes++;
            }
        }

        head++;
    }

    return countOnes;
};
// @lc code=end

