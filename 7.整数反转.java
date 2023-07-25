/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
  public int reverse(int x) {
    int res = 0;

    // 如果是正数取反，只要判断 x 一直大于 0 即可
    // 现在 x 可能是负数，所以应当是不等于 0 就继续
    while(x != 0) {
      // res 就是目前已经取反的部分
      // 如果原数字与整数的极值的位数相等，就有可能在翻转后溢出
      // 在倒数第二位的时候就要判断，看最后一位翻到最前面是不是会造成溢出
      // 如果超出了范围则返回 0
      if (res < Integer.MIN_VALUE/10 || res > Integer.MAX_VALUE/10) {
        return 0;
      }
      // 取出原数字末尾放到新数字后面
      int temp = x%10;
      res = res*10 + temp;
      x = x/10;
    }
    return res;
  }
}
// @lc code=end
