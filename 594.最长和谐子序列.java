/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start

class Solution {
    public int findLHS(int[] nums) {
        // 其实就是在数组里找两个相邻的数（差值为1），这两个数的总个数就是最终结果
        // 先把每个数字和次数统计到map里
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = 0;
        // 遍历每一个数字n，如果n-1也存在，那么就计算出n和n-1的次数之和，然后再跟res取大
        for (int n: nums) {
            if (map.containsKey(n - 1)) {
                res = Math.max(res, map.get(n) + map.get(n - 1));
            }
        }
        return res;
    }
}
// @lc code=end

