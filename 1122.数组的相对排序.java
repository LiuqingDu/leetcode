/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 计数排序
        // 因为数字范围不大,可以计数排序,统计每个数字的次数
        // 然后按照 arr2 的顺序把数字取出来, 剩下的再过一次遍历放在最后
        // 为了节约空间,可以只创建 [0, max(arr1)] 范围的数组用来计数

        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        // 计数
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            frequency[x]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        // 按照 arr2 的顺序把数字取出来
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        // 把剩下的数字按顺序取出来
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }
}
// @lc code=end

