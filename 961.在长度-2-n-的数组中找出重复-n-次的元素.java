/*
 * @lc app=leetcode.cn id=961 lang=java
 *
 * [961] 在长度 2N 的数组中找出重复 N 次的元素
 */

// @lc code=start
class Solution {
    public int repeatedNTimes(int[] nums) {
        // 考虑最多相隔多远就会出现重复的那个元素
        // 有 n 个重复元素，把它们都分隔开需要 n-1 个元素
        // 现在有 n 个不重复元素，使用其中 n-1 个去分隔 n 个重复元素
        // 剩下一个可以用来再继续加长一个分隔，使得一组相同元素中间隔了两个不同元素
        // 也就是说如果当前元素是重复元素，
        // 那么最多往前找 3 个元素就必定出现另一个重复元素
        
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i - 1] == nums[i]) {
                return nums[i];
            }
            if (i >= 2 && nums[i - 2] == nums[i]) {
                return nums[i];
            }
            if (i >= 3 && nums[i - 3] == nums[i]) {
                return nums[i];
            }
        }
        return 0;
    }
}
// @lc code=end

