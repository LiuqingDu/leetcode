/*
 * @lc app=leetcode.cn id=953 lang=java
 *
 * [953] 验证外星语词典
 */

// @lc code=start
class Solution {
    // 就是把原有的人类的字母表顺序变换为外星字母表
    // 人类字母表是 A:0, B:1, C:2...
    // 外星字母表是 A:x1, B:x2, C:x3...
    // 建立一个人类字母的顺序与外星字母顺序的关系
    // 比如： 0:x1, 1:x2, 2:x3...
    // 然后对每一个单词每一位进行比较
    int[] ord = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        // 外星字母表
        // ord 的索引表示人类的第几个字母，其值表示它在外星字母表的顺序
        for (int i = 0; i < 26; i++) {
            ord[order.charAt(i) - 'a'] = i;
        }

        int n = words.length;
        // 比较每个单词顺序
        for (int i = 1; i < n; i++) {
            // 大于零说明前一个单词比较大，应当排在后面
            if (check(words[i - 1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private int check(String a, String b) {
        int m = a.length(), n = b.length();
        int i = 0, j = 0;

        while (i < m && j < n) {
            // 取出每个字母
            int c1 = a.charAt(i) - 'a';
            int c2 = b.charAt(j) - 'a';
            if (c1 != c2) {
                // ord就是把人类字母的顺序转换为外星字母顺序
                return ord[c1] - ord[c2];
            }
            i++;
            j++;
        }

        // 如果第一个单词还有剩余，那么单词 a 比较大
        if (i < m) {
            return 1;
        }
        if (j < n) {
            return -1;
        }
        return 0;
    }
}
// @lc code=end

