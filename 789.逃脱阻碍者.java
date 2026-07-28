/*
 * @lc app=leetcode.cn id=789 lang=java
 *
 * [789] 逃脱阻碍者
 */

// @lc code=start
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        
        int[] source = {0, 0};
        int distance = manhattanDistance(source, target);
        for (int[] ghost : ghosts) {
            int ghostDistance = manhattanDistance(ghost, target);
            if (ghostDistance <= distance) {
                return false;
            }
        }
        return true;
    }

    public int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

}
// @lc code=end

