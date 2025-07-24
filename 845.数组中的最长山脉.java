/*
 * @lc app=leetcode.cn id=845 lang=java
 *
 * [845] 数组中的最长山脉
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] arr) {
        // 对于一个点,如果是山脉,它左边应该有下降,右边有下降
        // 计算两边下降的长度即可
        // 那么对于一个点,它如果它左边比它小,那么它的左侧下降数量就是left[i-1]+1
        // 如果左边比它大,则它的左侧下降数量就是0
        // 同理如果右边比它小,则它的右侧下降数量就是right[i+1]+1
        // 如果右边比它大,则它的右侧下降数量就是0
        int n = arr.length;
        if (n < 3) {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }
        int max = 0;
        // 遍历所有点,如果它的左侧和右侧都大于0,则说明它是山脉的顶点
        // 那么它的山脉长度就是左侧长度+右侧长度+1
        // 因为顶点本身也算在内
        for (int i = 0; i < n; i++) {
            if (left[i] > 0 && right[i] > 0) {
                max = Math.max(max, left[i] + right[i] + 1);
            }
        }
        return max;

        // 另一种思路是先找到山峰, 再向两边扩展, 找到山脉的长度
        // 具体看 js 解法
    }
}
// @lc code=end

