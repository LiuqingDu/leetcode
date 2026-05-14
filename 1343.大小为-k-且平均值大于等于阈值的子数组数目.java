/*
 * @lc app=leetcode.cn id=1343 lang=java
 *
 * [1343] 大小为 K 且平均值大于等于阈值的子数组数目
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int target = threshold * k; // 目标和
        int sum = 0;
        int count = 0;

        // 先计算第一个窗口的和
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        // 判断第一个窗口
        if (sum >= target) {
            count++;
        }

        // 开始滑动窗口
        for (int i = k; i < arr.length; i++) {

            // 加入右边新元素
            sum += arr[i];

            // 移除左边旧元素
            sum -= arr[i - k];

            // 判断当前窗口
            if (sum >= target) {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

