/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] 单词替换
 */

// @lc code=start
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // 先把前缀放入 set 中
        // 然后对于每个单词, 从短到长尝试前缀是否存在
        // 如果存在则替换整个单词

        // 先存入 set
        Set<String> dictionarySet = new HashSet<String>();
        for (String root : dictionary) {
            dictionarySet.add(root);
        }
        String[] words = sentence.split(" ");

        // 对于每个单词找它的前缀
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (dictionarySet.contains(word.substring(0, 1 + j))) {
                    words[i] = word.substring(0, 1 + j);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
}
// @lc code=end

