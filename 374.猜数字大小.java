/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int target = guess(mid);
            if (target == 0) {
                return mid;
            } else if (target == -1) {
                right = mid - 1;
            } else if (target == 1) {
                left = mid + 1;
            }
        }

        return 0;
        
    }
}
// @lc code=end

