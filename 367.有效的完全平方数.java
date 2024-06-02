/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        // 二分法
        // 如果判断的时候用mid*mid跟num判断，可能会溢出
        // 用除法来做可以用int类型
        if (num == 1) {
            return true;
        }

        int l = 0, r = num;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (num / mid > mid) {
                l = mid + 1;
            } else if (num / mid < mid) {
                r = mid - 1;
            } else {
                return num % mid == 0;
            }
        }
        return false;
    }
}
// @lc code=end

