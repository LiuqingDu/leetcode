/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {

        // 双指针，从两头往中间找，如果和大了则右指针往左，小了则左指针往右
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}
// @lc code=end

