/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */

// @lc code=start

import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // 这里提前把每个字母对应的行数写死了，也可以用代码生成这段，用题目给的包含三行字符的数组，转换为下面的编码字符串
        List<String> list = new ArrayList<>();
        String rowIndex = "12210111011122000010020202";
        for (String word: words) {
            boolean valid = true;
            char c = rowIndex.charAt(word.toLowerCase().charAt(0) - 'a');
            for (int i = 1; i < word.length(); i++) {
                if (rowIndex.charAt(word.toLowerCase().charAt(i) - 'a') != c) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
// @lc code=end

