/*
 * @lc app=leetcode.cn id=2660 lang=javascript
 *
 * [2660] 保龄球游戏的获胜者
 */

// @lc code=start
/**
 * @param {number[]} player1
 * @param {number[]} player2
 * @return {number}
 */
var isWinner = function(player1, player2) {
    const score = function(player) {
        let res = 0;
        for (let i = 0; i < player.length; i++) {
            if (i > 0 && player[i - 1] == 10 || i > 1 && player[i - 2] == 10) {
                res += 2 * player[i];
            } else {
                res += player[i];
            }
        }
        return res;
    }
    const s1 = score(player1);
    const s2 = score(player2);
    return s1 == s2 ? 0 : s1 > s2 ? 1 : 2;
};
// @lc code=end

