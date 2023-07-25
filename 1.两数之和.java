/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 使用一个 map 存储已经遍历过的数字和索引
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i< nums.length; i++) {
            // 目标是找符合的差值
            int dif = target - nums[i];
            // 如果差值是已经遍历过的数字则返回，
            // 否则把当前数字加入 map 中
            if (map.get(dif) != null) {
                return new int[]{map.get(dif), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
// @lc code=end

