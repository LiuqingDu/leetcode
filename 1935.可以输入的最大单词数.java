/*
 * @lc app=leetcode.cn id=1935 lang=java
 *
 * [1935] 可以输入的最大单词数
 */

// @lc code=start
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // 将坏掉的字母放进一个Set里，方便查询
        Set<Character> brokenSet = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            brokenSet.add(ch);
        }

        // 把整句拆成单词
        String[] words = text.split(" ");
        int count = 0;

        // 检查每个单词
        for (String word : words) {
            boolean canType = true;
            for (char ch : word.toCharArray()) {
                if (brokenSet.contains(ch)) {
                    canType = false; // 这个单词不能打
                    break;
                }
            }
            if (canType) {
                count++; // 能打，计数+1
            }
        }

        return count;
    }
}
// @lc code=end

