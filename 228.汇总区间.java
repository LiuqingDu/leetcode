/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        // 标记每个区间的开始
        int start = 0;
        // 遍历每一个数字
        for (int i = 0; i < nums.length; i++) {
            // 如果已经到最后一个数字，或者下一个数字跟当前数字不是连续的
            // 那么就需要添加区间
            // 否则就会进入下一轮循环
            if (i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {
                // start == i就是区间只有一个数字
                if (start == i) {
                    res.add("" + nums[start]);
                } else {
                    res.add("" + nums[start] + "->" + nums[i]);
                }
                // 处理完一个区间，下一个区间从下一个数字开始
                start = i + 1;
            }
        }

        return res;
    }
}
// @lc code=end

