/*
 * @lc app=leetcode.cn id=831 lang=java
 *
 * [831] 隐藏个人信息
 */

// @lc code=start
class Solution {
    public String maskPII(String s) {
        // 如果有@符号, 说明是邮箱, 否则是电话号码
        if (s.contains("@")) {
            String[] parts = s.split("@");
            String name = parts[0].toLowerCase();
            String domain = parts[1].toLowerCase();
            return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
        } else {
            s = s.replaceAll("[^0-9]", "");
            int len = s.length();
            if (len == 10) {
                return "***-***-" + s.substring(6);
            } else if (len == 11) {
                return "+*-***-***-" + s.substring(7);
            } else if (len == 12) {
                return "+**-***-***-" + s.substring(8);
            } else {
                return "+***-***-***-" + s.substring(9);
            }
        }
    }
}
// @lc code=end

