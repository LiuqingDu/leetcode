/*
 * @lc app=leetcode.cn id=1296 lang=java
 *
 * [1296] 划分数组为连续数字的集合
 */

// @lc code=start
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {

        // 1. 长度必须能整除
        if (nums.length % k != 0) return false;

        // 2. 统计频率
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // 3. 排序
        Arrays.sort(nums);

        // 4. 贪心构造
        for (int num : nums) {
            if (count.get(num) == 0) continue;
            // 从 num 开始构造 k 个连续数
            for (int i = 0; i < k; i++) {
                int cur = num + i;
                if (count.getOrDefault(cur, 0) == 0) {
                    return false;
                }
                count.put(cur, count.get(cur) - 1);
            }
        }

        return true;
    }
}
// @lc code=end

