/*
 * @lc app=leetcode.cn id=1576 lang=java
 *
 * [1576] 替换所有的问号
 */

// @lc code=start
class Solution {
    public String modifyString(String s) {
        // 要求问号跟它前后不重复,最差的情况是问号前后字母不同
        // 则问号需要是第三个字母
        // 所以实际上问号最多只需要 3 种备选字母,
        // 最差情况就是其中两种字母被前后占用,问号选择第三种即可
        // 不妨使用 a,b,c

        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                // 遇到问号,则从 a 开始选择替换字母尝试替换
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    // 如果前后都是待替换字母,则跳过,尝试下一个字母
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    // 如果待替换字母符合要求,跟前后都不同,则用来替换
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }
}
// @lc code=end

