/*
 * @lc app=leetcode.cn id=836 lang=java
 *
 * [836] 矩形重叠
 */

// @lc code=start
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 反着思考，如果两个矩形不重叠，说明它们在 x 轴和 y 轴上的投影，至少有一个投影是两个不重叠的线段
        // 判断是否投影是两段，然后取反
        return !((rec1[2] <= rec2[0]) || (rec1[0] >= rec2[2]) || (rec1[3] <= rec2[1]) || (rec1[1] >= rec2[3]));
    }
}
// @lc code=end

