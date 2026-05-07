/*
 * @lc app=leetcode.cn id=1324 lang=java
 *
 * [1324] 竖直打印单词
 */

// @lc code=start
class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        
        int maxLen = 0;
        for (String w : words) {
            maxLen = Math.max(maxLen, w.length());
        }

        List<String> res = new ArrayList<>();

        // 按“行”构建（其实是按列取字符）
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();

            for (String w : words) {
                if (i < w.length()) {
                    sb.append(w.charAt(i));
                } else {
                    sb.append(" ");
                }
            }

            // 去掉末尾空格
            int end = sb.length() - 1;
            while (end >= 0 && sb.charAt(end) == ' ') {
                end--;
            }

            res.add(sb.substring(0, end + 1));
        }

        return res;
    }
}
// @lc code=end

