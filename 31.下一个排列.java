/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int p = n - 1;

        while (p - 1 >= 0 && nums[p - 1] >= nums[p]) {
            p--;
        }

        if (p - 1 < 0) {
            reverse(nums, 0, n - 1);
            return;
        }

        int pivot = p - 1;
        p = n - 1;

        while (nums[p] <= nums[pivot]) {
            p--;
        }

        swap(nums, p, pivot);
        reverse(nums, pivot + 1, n - 1);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
// @lc code=end

