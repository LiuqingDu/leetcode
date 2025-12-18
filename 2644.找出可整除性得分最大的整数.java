/*
 * @lc app=leetcode.cn id=2644 lang=java
 *
 * [2644] 找出可整除性得分最大的整数
 */

// @lc code=start
class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int cnt = -1, ans = 0;

        for (int i = 0; i < divisors.length; i++) {
            int tmp = 0;
            for(int j = 0; j < nums.length; j++) {
                if (nums[j] % divisors[i] == 0) {
                    tmp++;
                }
            }

            if (tmp > cnt || (tmp == cnt && divisors[i] < ans)) {
                cnt = tmp;
                ans = divisors[i];
            }
        }
        return ans;
    }
}
// @lc code=end

