/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    // 因为已知集合是 1 到 n 的数，它们的索引是0到n-1
    // 如果数字没有重复，那么存在如下一一对应关系：
    // 每一个数字i可以对应索引为i-1的一个数，且对应关系不会重复
    // 现在因为有一个数字重复，则可以：
    // 遍历数组每一个数，把它对应的索引i-1的数做一个修改标记一下：改为负数
    // 当对应的数已经是负数的时候，说明当前i之前已经遍历过，也就是那个重复的数
    // 因为有一个数字缺失，则遍历完之后，有一个下标的数肯定没修改过，
    // 找出这个正数，对应的索引+1就是缺失的数
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 把当前数取绝对值，因为当前数可能已经被变为复数了
            int j = Math.abs(nums[i]);
            // 如果对应的索引的值已经被修改过，则当前数字是重复的数字
            if (nums[j - 1] < 0) {
                res[0] = j;
            } else {
                // 如果没修改过则改为复数
                nums[j - 1] = -nums[j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // 如果一个数没修改过，则它的坐标再+1就是缺失的数字
                res[1] = i + 1;
            }
        }
        return res;
    }
}
// @lc code=end

