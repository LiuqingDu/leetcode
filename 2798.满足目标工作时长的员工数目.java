/*
 * @lc app=leetcode.cn id=2798 lang=java
 *
 * [2798] 满足目标工作时长的员工数目
 */

// @lc code=start
class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return Arrays.stream(hours)
                .reduce(0, (pre, cur) -> pre + (cur >= target ? 1 : 0));
    }
}
// @lc code=end

