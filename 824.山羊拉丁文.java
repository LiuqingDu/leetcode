/*
 * @lc app=leetcode.cn id=824 lang=java
 *
 * [824] 山羊拉丁文
 */

// @lc code=start
class Solution {
    public String toGoatLatin(String sentence) {
        int n = sentence.length();
        StringBuilder sb = new StringBuilder();
        String prefix = "a";

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && sentence.charAt(j) != ' ') {
                j++;
            }

            if ("aeiouAEIOU".indexOf(sentence.charAt(i)) >= 0) {
                sb.append(sentence.substring(i, j));
            } else {
                sb.append(sentence.substring(i + 1, j)).append(sentence.charAt(i));
            }
            sb.append("ma").append(prefix);
            prefix += "a";
            i = j + 1;
            if (i < n) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
// @lc code=end

