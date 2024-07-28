/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        // 假设出现频率最大的值中的某一个记为A，（有可能同时有多个相同最多频次的）
        // 那么最短的连续子数组必定是包含A，且数组两头分别为第一个A和最后一个A，
        // 然后这个长度要最短
        // 可以维护一个hashmap，value是一个数组，分别记录该数字出现的次数，第一次出现的位置，最后出现的位置
        // 然后再遍历这个map，找到最短的数组

        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                // 次数+1
                map.get(nums[i])[0]++;
                // 记录最后的位置
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxCount = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry: map.entrySet()) {
            int[] arr = entry.getValue();
            // 如果有出现次数更大的，则重新记录最大次数和计算minLen
            if (maxCount < arr[0]) {
                maxCount = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxCount == arr[0]) {
                // 如果出现次数相同，则取长度的小值
                minLen = Math.min(minLen, arr[2] - arr[1] + 1);
            }
        }
        return minLen;
    }
}
// @lc code=end

