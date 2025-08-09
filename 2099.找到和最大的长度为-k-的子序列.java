/*
 * @lc app=leetcode.cn id=2099 lang=java
 *
 * [2099] 找到和最大的长度为 K 的子序列
 */

// @lc code=start
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // 首先，创建一个数组来存储结果
        int[] result = new int[k];
        // 然后，创建一个数组来存储索引和对应的值
        int[][] indexedNums = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexedNums[i][0] = nums[i]; // 存储值
            indexedNums[i][1] = i; // 存储索引
        }
        // 接下来，对 indexedNums 按照值进行降序排序
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(b[0], a[0]));
        // 然后，选择前 k 个最大的值，并记录它们的索引
        boolean[] selected = new boolean[nums.length];
        for (int i = 0; i < k; i++) {
            selected[indexedNums[i][1]] = true;
        }
        // 最后，构建结果数组，按照原数组的顺序
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) {
                result[index++] = nums[i];
            }
        }
        return result;
    }
}
// @lc code=end

