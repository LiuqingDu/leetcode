/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 数字是 1~n，索引是 1 ~ n-1
        // 可以一一对应，如果数字 k 存在，那么可以用下标 k-1 来记录
        // 可以把nums[k-1]变为负数，表示 k 存在
        // 如果已经是负数，说明 k 重复了
        int n = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            // 这个数字可能已经被变为负数了，所以取出原值要用绝对值
            int k = Math.abs(nums[i]);
            if (nums[k - 1] > 0) {
                nums[k - 1] = -nums[k - 1];
            } else {
                res.add(k);
            }
        }
        return res;
    }
}
// @lc code=end

