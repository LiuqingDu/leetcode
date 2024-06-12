/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        // w记录当前走过的是不是一个单词，
        // res统计总数量
        int res = 0;
        int w = 0;
        for (int i = 0; i < s.length(); i++) {
            // 遇到空格就把之前的单词数量累加
            // 并重置当前单词统计
            if (s.charAt(i) == ' ') {
                res += w;
                w = 0;
            } else {
                // 不是空格表示当前是一个单词
                w = 1;
            }
        }
        res += w;
        return res;

    }
}
// @lc code=end

