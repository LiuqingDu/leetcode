/*
 * @lc app=leetcode.cn id=2996 lang=java
 *
 * [2996] 大于等于顺序前缀和的最小缺失整数
 */

// @lc code=start
class Solution {
    public int missingInteger(int[] nums) {
        
        int sum = nums[0];
        
        // 1. 找最长顺序前缀
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // 2. 放入set方便查找
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 3. 找 >= sum 且不在数组里的最小数
        int x = sum;
        while (set.contains(x)) {
            x++;
        }

        return x;
    }
}
// @lc code=end

