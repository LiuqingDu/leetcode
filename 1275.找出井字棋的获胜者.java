/*
 * @lc app=leetcode.cn id=1275 lang=java
 *
 * [1275] 找出井字棋的获胜者
 */

// @lc code=start
class Solution {
    public String tictactoe(int[][] moves) {
        // 因为已知 moves 都是有效的,那么就不会出现已经有赢家的情况下继续下棋
        // 那么在最后一个 move 后,要么决出了胜者,要么是 draw 或者 pending
        // 区分 draw 和 pending 就只需要看是否下满棋盘即可
        // 如果是决出了胜者,那么就是最后一步出现的胜者
        // 只需要倒着推断最后一个人的棋子对局势的影响即可
        // 倒着推断一方面是无需考虑最后一个人是 A 还是 B
        // 另一方面是如果最后一个人胜出,倒着可以更快判断出来
        // 可以最大化跳过前期的没有决定胜局的棋子

        int m = moves.length;
        // 用数组记录0-2行、0-2列、正对角线、副对角线是否已满3个棋子
        // count[0-2]对应0-2行、count[3-5]对应0-2列、count[6]对应正对角线、count[7]对应副对角线
        int[] count = new int[8];
        // 倒序统计最后一个人走棋情况
        for(int i = m - 1; i >= 0; i -= 2) {
            // 此棋对行的影响
            count[moves[i][0]]++;
            // 此棋对列的影响
            count[moves[i][1] + 3]++;	
            // 此棋对正对角线的影响
            if(moves[i][0] == moves[i][1])
                count[6]++;
            // 此棋对副对角线的影响 (
            // 此处为3x3的情况，其余大小的棋盘可以类推
            if(moves[i][0] + moves[i][1] == 2)
                count[7]++;
            // 满3个棋子则胜利
            if(count[moves[i][0]] == 3 || count[moves[i][1] + 3] == 3 || 
                    count[6] == 3 || count[7] == 3) 
                // A先B后 则总长度为偶时 最后为B 反之为A
                return m % 2 == 0 ? "B" : "A";	
            }
        // 未胜时，棋盘未下满则继续
        if(moves.length < 9)
            return "Pending";
        // 未胜时，棋盘下满则平局结束
        return "Draw";
    }
}
// @lc code=end

