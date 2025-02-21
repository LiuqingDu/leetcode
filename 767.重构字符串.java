/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 */

// @lc code=start
class Solution {
    public String reorganizeString(String s) {
        // 明显,如果每个字符出现次数都不超过 n/2 则可以实现
        // 可以发现当一个字符刚好等于这个 limit 的时候(n 为偶数)
        // 或者刚好比 limit 大 1 的时候(n 为奇数)
        // 那么它必须放在偶数索引上
        // 建立两个数组用来记录必须放在偶数索引上和奇数索引上的字符
        // 优先放到奇数上,只有这个字符次数大于 n/2 的时候,
        // 或者奇数位置满了,才考虑放在偶数位置上

        if (s.length() < 2) {
            return s;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        // 如果最大次数大于这个临界值则无法实现
        // 临界值用 (length+1)/2 来同时处理 length 为奇数和偶数的情况
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] reorganizeArray = new char[length];
        // 两个指针用来填充奇数位置和偶数位置
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            // 当前字符次数不超过一半, 且奇数位置还有空
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                // 放入对应位置, 指针向后移动 2 位
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }
}
// @lc code=end

