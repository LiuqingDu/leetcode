/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        // 先记录每个字母出现的最后的位置
        // 然后再从头开始分割区间,记录区间的开头和结尾
        // 每遇到一个字母,那么当前区间的结尾就不能小于这个字母的最后出现位置
        // 直到走到当前区间结尾,那么形成一个区间并开始下一个区间

        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            // 当前区间的结尾不能小于当前字母最后出现位置
            end = Math.max(end, last[s.charAt(i) - 'a']);
            // 如果到了区间结尾则创建当前区间并开始新的
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
// @lc code=end

