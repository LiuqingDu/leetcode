/*
 * @lc app=leetcode.cn id=3074 lang=java
 *
 * [3074] 重新分装苹果
 */

// @lc code=start
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // 1. 计算苹果总数
        int sum = 0;
        for (int a : apple) {
            sum += a;
        }

        // 2. 容量从大到小排序
        Arrays.sort(capacity);

        int count = 0;
        int total = 0;

        // 3. 从最大的开始选
        for (int i = capacity.length - 1; i >= 0; i--) {
            total += capacity[i];
            count++;

            // 4. 满足条件就返回
            if (total >= sum) {
                return count;
            }
        }

        return count; // 题目保证一定有解
    }
}
// @lc code=end

