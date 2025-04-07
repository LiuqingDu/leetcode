/*
 * @lc app=leetcode.cn id=1389 lang=java
 *
 * [1389] 按既定顺序创建目标数组
 */

// @lc code=start
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            list.add(index[i], nums[i]);
        }
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
// @lc code=end

