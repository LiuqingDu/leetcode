/*
 * @lc app=leetcode.cn id=1560 lang=java
 *
 * [1560] 圆形赛道上经过次数最多的扇区
 */

// @lc code=start
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        // 其实每个阶段没有意义,可以理解为跑的过程中经过的区域,整个过程就是从 rounds[0] 到 rounds[n-1]
        // 中间会依次经过 rounds 中间那些元素对应的区域
        // 每经过一圈,对于每个扇区都贡献了 1, 实际上只需要考虑最后多出来的不足一圈的那部分
        // 也就是起点和终点之间的区域, 这里是指仅有起点和终点两个点,它们之间的不足一圈的那些扇区

        List<Integer> ret = new ArrayList<Integer>();
        int length = rounds.length;
        int start = rounds[0], end = rounds[length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                ret.add(i);
            }
        } else { // 由于题目要求按扇区大小排序，因此我们要将区间分成两部分
            for (int i = 1; i <= end; i++) {
                ret.add(i);
            }
            for (int i = start; i <= n; i++) {
                ret.add(i);
            }
        }
        return ret;
    }
}
// @lc code=end

