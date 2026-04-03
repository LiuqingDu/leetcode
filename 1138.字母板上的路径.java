/*
 * @lc app=leetcode.cn id=1138 lang=java
 *
 * [1138] 字母板上的路径
 */

// @lc code=start
class Solution {
    public String alphabetBoardPath(String target) {
        
        StringBuilder res = new StringBuilder();
        
        int curR = 0, curC = 0; // 起点 (0,0)
        
        for (char ch : target.toCharArray()) {
            int targetR = (ch - 'a') / 5;
            int targetC = (ch - 'a') % 5;
            
            // ⭐ 关键：先 U 和 L（避免 z 问题）
            
            // 上
            while (curR > targetR) {
                res.append('U');
                curR--;
            }
            
            // 左
            while (curC > targetC) {
                res.append('L');
                curC--;
            }
            
            // 下
            while (curR < targetR) {
                res.append('D');
                curR++;
            }
            
            // 右
            while (curC < targetC) {
                res.append('R');
                curC++;
            }
            
            // 收集字符
            res.append('!');
        }
        
        return res.toString();
    }
}
// @lc code=end

