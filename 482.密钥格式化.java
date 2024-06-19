/*
 * @lc app=leetcode.cn id=482 lang=java
 *
 * [482] 密钥格式化
 */

// @lc code=start
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        // 倒着处理，每有k个字符就加一个“-“
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, count = 0; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }
            // 如果上一段长度等于k，则在添加新的字符之前先加分隔符号
            if (count == k) {
                sb.append('-');
                count = 0;
            }
            sb.append(s.charAt(i));
            count++;
        }
        return sb.reverse().toString().toUpperCase();
    }
}
// @lc code=end

