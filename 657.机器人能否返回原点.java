/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int[] pos = new int[]{0, 0};
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'U') {
                pos[0]++;
            } else if (chars[i] == 'D') {
                pos[0]--;
            } else if (chars[i] == 'L') {
                pos[1]++;
            } else if (chars[i] == 'R') {
                pos[1]--;
            }
        }
        return pos[0] == 0 && pos[1] == 0;
    }
}
// @lc code=end

