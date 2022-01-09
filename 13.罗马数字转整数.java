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

    int result = 0;
    int n = s.length();
    for (int i = 0; i < (n - 1); i++) {
      if (value.get(s.charAt(i)) < value.get(s.charAt(i + 1))) {
        result -= value.get(s.charAt(i));
      } else {
        result += value.get(s.charAt(i));
      }
    }
    result += value.get(s.charAt(n - 1));
    return result;
  }
}
// @lc code=end
