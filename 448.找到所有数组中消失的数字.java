/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 就是把1到n放到索引为0到n-1的数组里，看缺了哪个数字
        // 把nums[i]放到索引为i-1的位置上，然后看哪个位置没有数字就行了
        // 这里把对应位置的数字设置为负数，表示这个索引对应的数字已经存在了
        // 注意这里有一个索引跟n错1位的问题
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 找到这个数字应该放在哪个索引上，注意要先取绝对值，有可能这个数字已经被改成负数了
            int ind = Math.abs(nums[i]) - 1;
            if (nums[ind] > 0) {
                nums[ind] = -nums[ind];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
// @lc code=end

