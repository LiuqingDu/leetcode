/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找共用字符
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] words) {
        // 计算出每个单词的字母出现次数,然后比对一下每个字母出现次数最小值
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char ch = word.charAt(i);
                freq[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        
        return res;
    }
}
// @lc code=end

