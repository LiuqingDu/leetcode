/*
 * @lc app=leetcode.cn id=962 lang=java
 *
 * [962] 最大宽度坡
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int N = nums.length;

        Integer[] B = new Integer[N];

        for (int i = 0; i < N; ++i) {
            B[i] = i;
        }

        Arrays.sort(B, (i, j) -> Integer.compare(nums[i], nums[j]));

        int ans = 0;
        int m = N;

        for (int i : B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}
// @lc code=end

