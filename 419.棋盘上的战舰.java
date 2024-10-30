/*
 * @lc app=leetcode.cn id=419 lang=java
 *
 * [419] 棋盘上的战舰
 */

// @lc code=start
class Solution {
    public int countBattleships(char[][] board) {
        // 根据题解，发现题目隐含了如下条件：确保了题目不会出现
        // 类似十字的排列，这种排列严格来讲不符合题目所说的舰队形状
        // 也就是说可以假设题目中只会出现符合舰队的形状
        // 只需要统计数量即可
        // 实际上一个舰队只需要找到舰队头部，然后统计多少个头部即可
        // 头部可以定义为是一个舰队的左上角那个战舰
        // 也就是如果一个战舰它左边和上边都没有战舰，那么它就是舰队头部

        int res = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    // 如果战舰的上面要么是界外要么没有战舰，且左边要么是界外要么没有战舰
                    // 那么它就是舰队头部
                    if ((i == 0 || board[i - 1][j] == '.')
                        && (j == 0 || board[i][j - 1] == '.')) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}
// @lc code=end

