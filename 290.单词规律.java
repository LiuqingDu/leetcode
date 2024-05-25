/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start

class Solution {
    // 类似lc205，那道题的方法是两个字符串之间互转
    // 还有一种方法是把它们翻译成第三种表达方式
    // 对于pattern，如果一个字母第一次出现，就记为一个数字，如果已经出现过就记对应数字
    // 对于s，同理，如果第一次出现就记为一个数字，已经出现就记对应数字
    // 相当于都翻译为数字，然后比较两个数字字符串
    public boolean wordPattern(String pattern, String s) {
        String[] strs1 = pattern.split("");
        String[] strs2 = s.split(" ");
        if (strs1.length != strs2.length) {
            return false;
        }
        return pattern(strs1).equals(pattern(strs2));
    }

    private String pattern(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        // 记录是第几个新字符/单词
        int count = 1;
        // 保存第三种数字表达方式
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            if (map.containsKey(str)) {
                sb.append(map.get(str));
            } else {
                map.put(str, count);
                sb.append(count);
                count++;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

