/*
 * @lc app=leetcode.cn id=769 lang=java
 *
 * [769] 最多能完成排序的块
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        // 题目可以看出 arr 长度为 n, 元素为 0 ~ n-1
        // 也就是说排序后每个元素等于它的索引
        // 那么在寻找块的时候记录当前的最大值
        // 同时观察索引,索引表示前面已经有多少个元素了
        // 如果最大值等于索引,说明到索引为止,已经有 x 个元素了
        // 且 x = 最大值 max
        // 那么说明前面的元素刚好跟索引可以一一对应
        // 此时就可以分割一个块

        int res = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            // 记录最大值
            max = Math.max(max, arr[i]);
            // 如果最大值等于索引,说明前面有 i 个元素,且它们最大值也是 i
            // 正好元素跟索引一一对应,可以形成排序后的数组的一部分, 也就是一个块
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

