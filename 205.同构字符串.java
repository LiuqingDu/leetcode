/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    // 依次比较每一位字符，把第一个字符串的字符映射为第二个字符串对应的字符
    // 如果已经映射过了，那么就检查第二个字符是不是符合映射规律
    // 另外，注意需要映射s->t和t->s，因为一遍映射只能保证s里每个相同的字符都映射到了同一个字符上
    // 但并不能保证不同的字符没有映射到不同的字符，完全有可能左边所有字符都映射到了同一个字符
    // 所以需要交换它们再检查一次
    public boolean isIsomorphic(String s, String t) {
        // 检查两个方向的映射
        return helper(s, t) && helper(t, s);
    }

    private boolean helper(String a, String b) {
        Map<Character, Character> map = new HashMap<>();
        int n = a.length();
        for (int i = 0; i < n; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            // 如果已经映射过了就检查是不是符合以前的映射关系
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                // 没有映射过就添加上
                map.put(c1, c2);
            }
        }
        return true;
    }
}
// @lc code=end

