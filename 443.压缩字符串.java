/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        // 三指针，一个指向当前处理的字符，一个向后计算当前字符有多少个
        // 一个指针指向当前读写位置

        int n = chars.length;
        int write = 0;

        for (int i = 0; i < n;) {
            // 从当前字符开始
            int j = i;
            // 找到当前同字符的末尾
            while (j < n && chars[i] == chars[j]) {
                j++;
            }
            chars[write] = chars[i];
            write++;
            // j 指向同字符的下一个，也就是已经不指向同字符了
            // 大于 1 就是不止一个字符，需要拼接数字
            if (j - i > 1) {
                String tmp = Integer.toString(j - i);
                for (int k = 0; k < tmp.length(); k++) {
                    chars[write] = tmp.charAt(k);
                    write++;
                }
            }
            i = j;
        }
        return write;
    }
}
// @lc code=end

