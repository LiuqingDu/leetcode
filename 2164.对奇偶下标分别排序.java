/*
 * @lc app=leetcode.cn id=2164 lang=java
 *
 * [2164] 对奇偶下标分别排序
 */

// @lc code=start
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        // 提取奇数和偶数下标的元素
        int[] even = new int[(nums.length + 1) / 2];
        int[] odd = new int[nums.length / 2];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[i / 2] = nums[i];
            } else {
                odd[i / 2] = nums[i];
            }
        }
        // 对偶数下标的元素进行升序排序
        Arrays.sort(even);
        // 对奇数下标的元素进行降序排序
        Arrays.sort(odd);
        // 合并结果
        int[] result = new int[nums.length];
        int evenIdx = 0, oddIdx = odd.length - 1;
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = even[evenIdx++];
            } else {
                result[i] = odd[oddIdx--];
            }
        }
        return result;
    }
}
// @lc code=end

