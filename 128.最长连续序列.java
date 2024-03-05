/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();

        for (int num: nums) {
            set.add(num);
        }

        int res = 0;

        for (int num: set) {
            if (!set.contains(num - 1)) {
                int i = num;
                int count = 0;
                while (set.contains(i)) {
                    i++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }
}
// @lc code=end

