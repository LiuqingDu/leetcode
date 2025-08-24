/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 二分查找
        int left = 1, right = 1000000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long hours = getHours(piles, mid);
            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private long getHours(int[] piles, int speed) {
        long hours = 0;
        for (int pile : piles) {
            int curHours= (pile + speed - 1) / speed;
            hours += curHours;
        }
        return hours;
    }
}
// @lc code=end

