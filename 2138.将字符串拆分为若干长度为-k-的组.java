/*
 * @lc app=leetcode.cn id=2138 lang=java
 *
 * [2138] 将字符串拆分为若干长度为 k 的组
 */

// @lc code=start
class Solution {
    public String[] divideString(String s, int k, char fill) {
        // 计算需要的组数
        int n = s.length();
        int groupCount = (n + k - 1) / k; // 向上取整
        String[] result = new String[groupCount];
        for (int i = 0; i < groupCount; i++) {
            int start = i * k;
            int end = Math.min(start + k, n);
            StringBuilder sb = new StringBuilder(s.substring(start, end));
            // 如果最后一组长度不足 k，填充字符
            while (sb.length() < k) {
                sb.append(fill);
            }
            result[i] = sb.toString();
        }
        return result;
    }
}
// @lc code=end

