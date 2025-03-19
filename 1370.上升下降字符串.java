/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
class Solution {
    public String sortString(String s) {
        // 其实就是从原字符串里先从 a-z 各取一个字符
        // 然后再从 z-a 各取一个字符, 反复如此直到取完
        // 可以用桶排序方法, 开辟 26 个桶,把原字符串的字符放入对应的桶
        // 然后依次从每个桶里取一个字符, 如此反复

        int[] bucket = new int[26];
        int n = s.length();
        char[] res = new char[n];
        for (char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }

        // 记录 res 中该放到第几个位置里
        int i = 0;
        while (i < n) {
            // 先从小到大取一次
            for (int ind = 0; ind < 26; ind++) {
                if (bucket[ind] > 0) {
                    res[i] = (char) ('a' + ind);
                    i++;
                    bucket[ind]--;
                }
            }
            // 再从大到小
            for (int ind = 25; ind >= 0; ind--) {
                if (bucket[ind] > 0) {
                    res[i] = (char) ('a' + ind);
                    i++;
                    bucket[ind]--;
                }
            }
        }

        return String.valueOf(res);
    }
}
// @lc code=end

