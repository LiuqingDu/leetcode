/*
 * @lc app=leetcode.cn id=748 lang=java
 *
 * [748] 最短补全词
 */

// @lc code=start
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = getCount(licensePlate);
        String res = null;
        for (String word: words) {
            int[] count = getCount(word);
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] < target[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (res == null || res.length() > word.length()) {
                    res = word;
                }
            }
        }
        return res;
    }

    private int[] getCount(String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            if (Character.isLetter(c)) {
                count[Character.toLowerCase(c) - 'a'] ++;
            }
        }
        return count;
    }
}
// @lc code=end

