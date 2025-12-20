/*
 * @lc app=leetcode.cn id=1023 lang=java
 *
 * [1023] 驼峰式匹配
 */

// @lc code=start
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        // 双指针
        // 用一个指针 p 遍历 pattern，再顺序遍历 queries[i] 的每个字符：
        // 	•	如果当前字符等于 pattern[p]，就匹配成功，p++。
        // 	•	否则，如果该字符是大写字母，说明多出了不允许的字符，直接匹配失败；
        // 	•	如果是小写字母，可以忽略，继续遍历。

        // 遍历结束后，若 pattern 还有未匹配的字符（p < pattern.length），则失败；否则匹配成功。
        int n = queries.length;
        List<Boolean> res = new ArrayList<Boolean>();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            int p = 0;
            for (int j = 0; j < queries[i].length(); j++) {
                char c = queries[i].charAt(j);
                if (p < pattern.length() && pattern.charAt(p) == c) {
                    p++;
                } else if (Character.isUpperCase(c)) {
                    flag = false;
                    break;
                }
            }
            if (p < pattern.length()) {
                flag = false;
            }
            res.add(flag);
        }
        return res;
    }
}
// @lc code=end

