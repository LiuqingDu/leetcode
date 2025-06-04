 /*
 * @lc app=leetcode.cn id=1791 lang=java
 *
 * [1791] 找出星型图的中心节点
 */

// @lc code=start
class Solution {
    public int findCenter(int[][] edges) {
        // 星型图是只有一个中心点,其余点只跟中心点相连
        // 那么也就是说对于任意两条边,它们之间的共同点就是中心点

        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
// @lc code=end

