/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    int rev = 0;
    int ori = x;
    while (x != 0) {
      if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
        return false;
      }
      int d = x % 10;
      x = x / 10;
      rev = rev * 10 + d;
    }
    if (rev == ori) {
      return true;
    }
    return false;
  }
}
// @lc code=end
