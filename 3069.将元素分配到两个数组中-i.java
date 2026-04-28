/*
 * @lc app=leetcode.cn id=3069 lang=java
 *
 * [3069] 将元素分配到两个数组中 I
 */

// @lc code=start
class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // 前两个元素
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        // 从第3个开始
        for (int i = 2; i < nums.length; i++) {
            int last1 = arr1.get(arr1.size() - 1);
            int last2 = arr2.get(arr2.size() - 1);

            if (last1 > last2) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // 合并结果
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : arr1) {
            result[index++] = num;
        }
        for (int num : arr2) {
            result[index++] = num;
        }

        return result;
    }
}
// @lc code=end

