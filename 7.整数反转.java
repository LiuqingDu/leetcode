/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
  public int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
        return 0;
      }
      int d = x % 10;
      x = x / 10;
      rev = rev * 10 + d;
    }
    return rev;
  }
}
// @lc code=end
