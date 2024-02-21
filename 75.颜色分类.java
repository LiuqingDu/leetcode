/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int r = 0, w = 0, b = 0;
        int p = 0;

        while (p < n) {
            switch (nums[p]) {
                case 0:
                    nums[r] = 0;
                    r++;
                case 1:
                    if (w != r - 1) {
                        nums[w] = 1;
                    }
                    w++;
                case 2:
                    if (b != w - 1) {
                        nums[b] = 2;
                    }
                    b++;
            }
            p++;
        }

    }
}
// @lc code=end

