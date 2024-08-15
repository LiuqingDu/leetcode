/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start

import java.util.Map;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<String>();
        for (String s: banned) {
            set.add(s);
        }

        char[] cs = paragraph.toCharArray();
        int n = cs.length;
        Map<String, Integer> map = new HashMap<>();
        String res = null;

        int i = 0;
        while (i < n) {
            if (!Character.isLetter(cs[i])) {
                i++;
                continue;
            }

            int j = i;
            while (j < n && Character.isLetter(cs[j])) {
                j++;
            }

            String word = paragraph.substring(i, j).toLowerCase();
            i = j + 1;

            if (set.contains(word)) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (res == null || map.get(res) < map.get(word)) {
                res = word;
            }
        }

        return res;
    }
}
// @lc code=end

