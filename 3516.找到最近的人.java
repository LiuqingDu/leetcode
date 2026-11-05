/*
 * @lc app=leetcode.cn id=3516 lang=java
 *
 * [3516] 找到最近的人
 */

// @lc code=start
class Solution {
    public int findClosest(int x, int y, int z) {
        int dif =  Math.abs(x - z) - Math.abs(y - z);
        if (dif > 0) {
            return 2;
        } else if (dif < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
// @lc code=end

