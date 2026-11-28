/*
 * @lc app=leetcode.cn id=3861 lang=java
 *
 * [3861] 容量最小的箱子
 */

// @lc code=start
class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int min = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize && capacity[i] < min) {
                min = capacity[i];
                ind = i;
            }
        }
        return ind;
    }
}
// @lc code=end

