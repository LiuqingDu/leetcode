/*
 * @lc app=leetcode.cn id=2283 lang=java
 *
 * [2283] 判断一个数的数字计数是否等于数位的值
 */

// @lc code=start
class Solution {
    public boolean digitCount(String num) {
        // 统计每个数字出现的次数
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if (count[i] != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

