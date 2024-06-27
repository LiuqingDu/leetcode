/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        // 条件可以合并为：
        // 如果第一个字符是小写，那么第二个字符也得是小写
        // 除了第一个字符外，后面的字符的大小写必须是一致的

        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            // 判断第二个字符和后面的字符大小写关系，
            // 同时判断它们是不是小写，结果应当相同，否则就是它们大小写不一致
            if (Character.isLowerCase(word.charAt(1)) != Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

