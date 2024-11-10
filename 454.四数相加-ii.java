/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 先把所有 A+B 可能的结果存起来
        // 然后对 C 和 D 遍历，如果 -(C+D) 存在于之前保存的结果里
        // 则说明有一组答案

        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : nums1) {
            for (int v : nums2) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : nums3) {
            for (int v : nums4) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

