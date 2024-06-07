/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        // 字符串里每有两个相同的字符，就可以往回文串里头尾放一个
        // 最后如果回文串长度跟s长度相同，说明正好所有字符都成对
        // 如果回文串长度小于s长度，说明至少有一个字符孤单了，那么从这些孤单的字符里随便取一个
        // 可以放到回文串里当作中心那唯一一个单独字符，因此长度+1；
        int res = 0;
        int arr[] = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
            if (arr[s.charAt(i)] % 2 == 0) {
                res+=2;
            }
        }
        if (res < s.length()) {
            res++;
        }
        return res;

    }
}
// @lc code=end

