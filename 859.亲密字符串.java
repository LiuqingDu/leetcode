/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String s, String goal) {
        // 两种可能
        // 1. 只有两个字符对不上，交换这两个字符
        // 2. 所有字符都对得上，且 s 里有字符出现了至少两次，可以把这两个相同字符交换一下
        // 依次比较每一位的字符，统计对不上的字符的数量
        // 同时记录每个字符出现的次数
        // 至于对不上的两组字符是否互相对应，可以通过检查每个字符的数量是否相等来确认

        int m = s.length();
        int n = goal.length();

        // 字符串长度不等
        if (m != n) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        // 对不上的字符数量
        int sum = 0;

        for (int i = 0; i < m; i++) {
            int a = s.charAt(i) - 'a';
            int b = goal.charAt(i) - 'a';
            // 统计当前字符出现次数
            count1[a]++;
            count2[b]++;
            // 当前字符对不上，统计数量
            if (a != b) {
                sum++;
            }
        }

        // 是否可以交换一下 s 的相同字符来满足要求
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            // 判断每个字符出现次数，如果不同，则说明即使 sum为2，也不是两组互相对应的字符
            if (count1[i] != count2[i]) {
                return false;
            }
            // 只要有一个字符出现两次就行
            if (count1[i] >= 2) {
                flag = true;
            }
        }

        return sum == 2 || (sum == 0 && flag);
    }
}
// @lc code=end

