/*
 * @lc app=leetcode.cn id=2869 lang=java
 *
 * [2869] 收集元素的最少操作次数
 */

// @lc code=start
class Solution {
    public int minOperations(List<Integer> nums, int k) {
        // 实际上就是从末尾往前,直到凑够1~k为止
        // 用一个boolean记录遇到的<=k的数量,直到数量等于k即可
        // boolean[] 比set性能要好一点,省内存
        boolean[] seen = new boolean[k + 1];
        int count = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            int x = nums.get(i);

            if (x <= k && !seen[x]) {
                seen[x] = true;
                count++;
            }

            if (count == k) {
                return nums.size() - i;
            }
        }

        return nums.size(); // 理论上不会走到这里
    }
}
// @lc code=end

