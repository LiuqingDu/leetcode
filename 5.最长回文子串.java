/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {

  boolean dp[][];

  public String longestPalindrome(String s) {
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      // 获取以 s[i] 为中心的最大回文串
      String s1 = palindrome(s, i, i);
      // 获取以 s[i] 和 s[i+1] 两位为中心的最大回文串
      String s2 = palindrome(s, i, i+1);

      res = res.length() >= s1.length() ? res: s1;
      res = res.length() >= s2.length() ? res: s2;
    }
    return res;

  }

  // 以 left 和 right 开始向两边扩散查找最大回文
  private String palindrome(String s, int left, int right) {
    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    // 跳出循环时左右两边已经不相等了，应当往中间走一位
    // 应当是 left + 1 和 right - 1;
    // substring 右边是开区间，不包含第二个参数所在的字符
    // 因此第二个参数应当再+1 才能截取到正确位置
    // 第二个参数变为 right+1-1 = right
    return s.substring(left + 1, right);
  }
}
// @lc code=end
