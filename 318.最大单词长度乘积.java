/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        // 要知道两个单词是否有重复字母，可以用位图表示每一个单词有什么字母
        // 更进一步，可以用二进制的每一位表示一个字母，26 个二进制位对应 26 个字母
        // 该位为 1 表示存在这个字母
        // 每个单词可以用一个二进制位数表示，
        // 若两个单词字母表不同，则它们的二进制数的按位与等于 0
        // 这样可以快速比较出两个单词是否有重复字母
        // 然后对每组不同的两个单词计算长度积

        // 这个方法可以进一步优化，对于单词 meet 和 met，它们的字母表是一样的，
        // 但它们会分别计算一次，实际上只有长度更长的那个才有用，
        // 可以维护一个 map，记录每种单词表的最长单词长度，这样 met 就不需要被计算了

        Map<Integer, Integer> map = new HashMap<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            // 二进制数代表字母表，记为掩码
            int mask = 0;
            String word = words[i];
            int l = word.length();

            for (int j = 0; j < l; j++) {
                // |= 右边是当前字母的二进制位表示，就是从右往左开始第x位是 1，表示存在第 x 个字母
                // 每次 |= 运算，记录本次存在的字母
                mask |= 1 << (word.charAt(j) - 'a');
            }

            // 当前字母长度如果更长，则更新当前掩码对应的单词长度
            if (l > map.getOrDefault(mask, 0)) {
                map.put(mask, l);
            }
        }

        int res = 0;
        Set<Integer> maskSet = map.keySet();
        // 每个单词互相比较
        // 这里会出现同一个单词自己跟自己比较，但不影响，因为一个单词至少有一个字母，
        // 那么它的掩码就不等于 0，它与自己的掩码做与运算不会等于 0，也不会计算到结果当中
        for (int mask1 : maskSet) {
            int l1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int l2 = map.get(mask2);
                    res = Math.max(res, l1 * l2);
                }
            }
        }

        return res;
    }
}
// @lc code=end

