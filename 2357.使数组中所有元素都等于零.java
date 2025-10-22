/*
 * @lc app=leetcode.cn id=2357 lang=java
 *
 * [2357] 使数组中所有元素都等于零
 */

// @lc code=start
class Solution {
    public int minimumOperations(int[] nums) {
        // 每一个操作都会让最小的非零数变为0
        // 相同的数字会在同时变为0
        // 所以有多少种不同的数字就是最小的操作数

        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}
// @lc code=end

