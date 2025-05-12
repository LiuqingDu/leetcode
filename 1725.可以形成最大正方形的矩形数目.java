/*
 * @lc app=leetcode.cn id=1725 lang=java
 *
 * [1725] 可以形成最大正方形的矩形数目
 */

// @lc code=start
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        // 注意是首先要边长最大,其次是统计该边长的正方形有多少个
        // 记录当前最大边长是多少,以及该边长正方形已经有多少个
        // 当新边长等于最大边长,则个数+1
        // 如果新边长大于当前最大边长时, 替换最大边长,且个数重置为 1
        int res = 0, maxLen = 0;
        for (int[] rectangle : rectangles) {
            int l = rectangle[0], w = rectangle[1];
            int k = Math.min(l, w);
            if (k == maxLen) {
                ++res;
            } else if (k > maxLen) {
                res = 1;
                maxLen = k;
            }
        }
        return res;
    }
}
// @lc code=end

