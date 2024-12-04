/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // 题目要在 dict 当中寻找 s 的子串,且要长度最长,其次是字母排序优先
        // 那么可以先把 dict 按照长度排序,相同长度的按照字母排序
        // 然后按照排序后的结果依次尝试看 dict[i] 的每个字母是否能按顺序出现在 s 当中
        // 如果有就是最终结果
        // 寻找是否子串可以用双指针分别指向 s 和 dict[i], 如果 dict[i] 到头了就说明存在

        // 按照长度降序排列，若长度相同则按字母顺序升序排列
        dictionary.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length(); // 长度降序
            }
            return o1.compareTo(o2); // 字母顺序升序
        });

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                return word; // 找到第一个满足条件的就是结果
            }
        }

        return ""; // 如果没有找到，返回空字符串
    }

    // 判断 word 是否是 s 的子序列
    private boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            // 无论如何 s 的指针要前进
            j++;
        }
        return i == word.length(); // 如果 word 的所有字符都被匹配完，返回 true
    }
}
// @lc code=end

