/*
 * @lc app=leetcode.cn id=1863 lang=java
 *
 * [1863] 找出所有子集的异或总和再求和
 */

// @lc code=start
class Solution {

    int sum = 0;

    private void dfs(int[] nums, int index, int xor) {
        // 每个状态都是一个子集
        sum += xor;

        for (int i = index; i < nums.length; i++) {
            dfs(nums, i + 1, xor ^ nums[i]);
        }
    }

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return sum;
    }
}
// @lc code=end

