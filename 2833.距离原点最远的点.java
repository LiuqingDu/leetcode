/*
 * @lc app=leetcode.cn id=2833 lang=java
 *
 * [2833] 距离原点最远的点
 */

// @lc code=start
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0;   // 尽量往左的最终位置
        int right = 0;  // 尽量往右的最终位置

        for (char c : moves.toCharArray()) {
            // 计算尽量往左
            if (c == 'L' || c == '_') {
                left--;
            } else { // 'R'
                left++;
            }

            // 计算尽量往右
            if (c == 'R' || c == '_') {
                right++;
            } else { // 'L'
                right--;
            }
        }

        return Math.max(Math.abs(left), Math.abs(right));
    }
}
// @lc code=end

