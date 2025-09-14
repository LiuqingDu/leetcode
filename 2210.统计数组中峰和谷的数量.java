/*
 * @lc app=leetcode.cn id=2210 lang=java
 *
 * [2210] 统计数组中峰和谷的数量
 */

// @lc code=start
class Solution {
    public int countHillValley(int[] nums) {
        // pre标记前一个位置的状态，1为上坡，-1为下坡，
        // 如果前一个位置为1，现在为-1，说明出现山峰，
        // 反之则是山谷；如果一直为1则还是上坡，反之下坡。
        int n = nums.length;
        int cnt = 0;
        int pre = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (pre == -1) {
                    cnt++;
                }
                pre = 1;
            } else if (nums[i] < nums[i + 1]) {
                if (pre == 1) {
                    cnt++;
        		}
        		pre = -1;
        	}
        }
        return cnt;
    }
}
// @lc code=end

