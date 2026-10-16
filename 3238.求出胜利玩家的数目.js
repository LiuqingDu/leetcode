/*
 * @lc app=leetcode.cn id=3238 lang=javascript
 *
 * [3238] 求出胜利玩家的数目
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} pick
 * @return {number}
 */
var winningPlayerCount = function(n, pick) {
    
    let cnt = Array.from({ length: n }, () => Array(11).fill(0)); 
    pick.forEach(p => {
        cnt[p[0]][p[1]]++;
    });
    return cnt.filter((player, i) => 
        player.some((count, j) => count > i)
    ).length;

};
// @lc code=end

