/*
 * @lc app=leetcode.cn id=1138 lang=javascript
 *
 * [1138] 字母板上的路径
 */

// @lc code=start
/**
 * @param {string} target
 * @return {string}
 */
var alphabetBoardPath = function(target) {
    
    let res = '';
    
    let curR = 0, curC = 0; // 起点 (0,0)
    
    for (let ch of target) {
        let targetR = Math.floor((ch.charCodeAt(0) - 97) / 5);
        let targetC = (ch.charCodeAt(0) - 97) % 5;
        
        // ⭐ 顺序很重要：U → L → D → R
        
        // 上
        while (curR > targetR) {
            res += 'U';
            curR--;
        }
        
        // 左
        while (curC > targetC) {
            res += 'L';
            curC--;
        }
        
        // 下
        while (curR < targetR) {
            res += 'D';
            curR++;
        }
        
        // 右
        while (curC < targetC) {
            res += 'R';
            curC++;
        }
        
        // 收集字母
        res += '!';
    }
    
    return res;
};
// @lc code=end

