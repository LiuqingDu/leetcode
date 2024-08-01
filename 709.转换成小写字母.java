/*
 * @lc app=leetcode.cn id=709 lang=java
 *
 * [709] 转换成小写字母
 */

// @lc code=start
class Solution {
    public String toLowerCase(String s) {
        // 大写小写字母之间的ascii码相差32
        // 不是相差26而是32是方便大小写转换
        // 相差32那么就是二进制右数第6位不同，其他都相同
        // 只需要把第六位转换一下就可以了
        // 大写字母第六位是0，小写是1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 65 && c <= 90) {
                c |= 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
// @lc code=end

