/*
 * @lc app=leetcode.cn id=1550 lang=java
 *
 * [1550] 存在连续三个奇数的数组
 */

// @lc code=start
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int left = 0, right = 0;
        while (right < n) {
            if (arr[right] % 2 == 1) {
                if (right - left == 2) {
                    return true;
                }
                right++;
            } else {
                right++;
                left = right;
            }
        }
        return false;
    }
}
// @lc code=end

