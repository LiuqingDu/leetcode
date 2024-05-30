/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start

class Solution {
    static char[] arr = new char[]{'a', 'e', 'i', 'o', 'u'};
    static Set<Character> set = new HashSet<>();
    static {
        for (char c: arr) {
            set.add(c);
            set.add(Character.toUpperCase(c));
        }
    }
    public String reverseVowels(String s) {
        // 双指针，两边遇到元音字母就交换
        // 把set存到静态变量里，提升连续跑测试用例的速度

        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        while (l < r) {
            if (set.contains(cs[l]) && set.contains(cs[r])) {
                char tmp = cs[l];
                cs[l] = cs[r];
                cs[r] = tmp;
                l++;
                r--;
            } else {
                if (!set.contains(cs[l])) {
                    l++;
                }
                if (!set.contains(cs[r])) {
                    r--;
                }
            }
        }
        return String.valueOf(cs);
    }
}
// @lc code=end

