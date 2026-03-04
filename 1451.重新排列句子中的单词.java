/*
 * @lc app=leetcode.cn id=1451 lang=java
 *
 * [1451] 重新排列句子中的单词
 */

// @lc code=start
class Solution {
    public String arrangeWords(String text) {
        // 1. 统一转成小写
        text = text.toLowerCase();
        
        // 2. 拆分单词
        String[] words = text.split(" ");
        
        // 3. 按长度升序排序（稳定排序）
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        // 4. 拼接结果
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(" ");
        }
        
        // 去掉最后一个空格
        sb.deleteCharAt(sb.length() - 1);
        
        // 5. 首字母大写
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        
        return sb.toString();
    }
}
// @lc code=end

