/*
 * @lc app=leetcode.cn id=3375 lang=java
 *
 * [3375] 使数组的值全部为 K 的最少操作次数
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int k) {
        
        Set<Integer> st = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1;
            } else if (x > k) {
                st.add(x);
            }
        }
        return st.size();

    }
}
// @lc code=end

