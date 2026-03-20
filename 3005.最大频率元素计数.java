/*
 * @lc app=leetcode.cn id=3005 lang=java
 *
 * [3005] 最大频率元素计数
 */

// @lc code=start
class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int a : nums) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }

        int max = 0;
        for (int a : count.values()) {
            if (a > max) {
                max = a;
            }
        }

        int res = 0;
        for (int a : count.values()) {
            if (a == max) {
                res += a;
            }
        }
        return res;
    }
}
// @lc code=end

