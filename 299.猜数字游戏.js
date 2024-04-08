/*
 * @lc app=leetcode.cn id=299 lang=javascript
 *
 * [299] 猜数字游戏
 */

// @lc code=start
/**
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 */
var getHint = function(secret, guess) {

    let n = secret.length;
    let a = 0, b = 0;
    let se = new Array(10).fill(0);
    let gu = new Array(10).fill(0);

    for (let i = 0; i < n; i++) {
        let c1 = secret.charCodeAt(i) - '0'.charCodeAt(0);
        let c2 = guess.charCodeAt(i) - '0'.charCodeAt(0);
        if (c1 === c2) {
            a++;
        } else {
            se[c1]++;
            gu[c2]++;
        }
    }

    for (let i = 0; i < 10; i++) {
        b += Math.min(se[i], gu[i]);
    }

    return a + "A" + b + "B";
};
// @lc code=end

