/*
 * @lc app=leetcode.cn id=1275 lang=javascript
 *
 * [1275] 找出井字棋的获胜者
 */

// @lc code=start
/**
 * @param {number[][]} moves
 * @return {string}
 */
var tictactoe = function(moves) {
    let m = moves.length;
    let count = new Array(8).fill(0);
    
    for (let i = m - 1; i >= 0; i -= 2) {
        count[moves[i][0]]++;
        count[moves[i][1] + 3]++;
        
        if (moves[i][0] === moves[i][1]) { 
            count[6]++; 
        }
        
        if (moves[i][0] + moves[i][1] === 2) { 
            count[7]++; 
        }
        
        if (count[moves[i][0]] === 3 || count[moves[i][1] + 3] === 3 || count[6] === 3 || count[7] === 3) { 
            return m % 2 === 0 ? "B" : "A"; 
        }
    }
    
    if (m < 9) { 
        return "Pending"; 
    }
    
    return "Draw";
};
// @lc code=end

