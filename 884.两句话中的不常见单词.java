/*
 * @lc app=leetcode.cn id=884 lang=java
 *
 * [884] 两句话中的不常见单词
 */

// @lc code=start

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String str = s1 + " " + s2;
        String[] words = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String k: map.keySet()) {
            if (map.get(k) == 1) {
                list.add(k);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
// @lc code=end

