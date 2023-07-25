import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
  public int romanToInt(String s) {
    HashMap<Character, Integer> value = new HashMap<Character, Integer>();
    value.put('I', 1);
    value.put('V', 5);
    value.put('X', 10);
    value.put('L', 50);
    value.put('C', 100);
    value.put('D', 500);
    value.put('M', 1000);

    // 罗马数字的规律是，如果一个数字比右边小，则减去当前数字
    // 如果当前数字比右边大或者相等，则加上这个数字
    // 可以把当前数字与右边比较，来判断是加还是减
    // 最后一位没有再右边的数字，永远是加

    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      // 最后一位直接加
      if (i == s.length() - 1) {
        result += value.get(s.charAt(i));
      } else {
        // 与下一位比较，相等或者大于都是加
        if (value.get(s.charAt(i)) >= value.get(s.charAt(i + 1))) {
          result += value.get(s.charAt(i));
        } else {
          result -= value.get(s.charAt(i));
        }
      }
    }
    return result;
  }
}
// @lc code=end
