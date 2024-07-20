/*
 * @lc app=leetcode.cn id=657 lang=javascript
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
/**
 * @param {string} moves
 * @return {boolean}
 */
var judgeCircle = function(moves) {
    let pos = [0, 0];
    for (let i = 0; i < moves.length; i++) {
        switch (moves[i]) {
            case 'U':
                pos[0]++;
                break;
            case 'D':
                pos[0]--;
                break;
            case 'L':
                pos[1]++;
                break;
            case 'R':
                pos[1]--;
                break;
        }
    }
    return pos[0] === 0 && pos[1] === 0;
};
// @lc code=end

