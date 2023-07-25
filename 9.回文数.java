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
    while(x > 0) {
      // 如果翻转后会溢出，则肯定不是回文数，此处逻辑参考题号 7
      if (rev < Integer.MIN_VALUE/10 || rev > Integer.MAX_VALUE/10) {
        return false;
      }
      int temp = x % 10;
      rev = rev * 10 + temp;
      x = x / 10;
    }
    return rev == ori;
  }
}
// @lc code=end
