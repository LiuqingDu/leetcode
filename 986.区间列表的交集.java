/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
class Solution {
    // 将两条区间在坐标轴上对齐来看，分别用两个指针i和j指向两条各自的一个区间，
    // 如果存在相交的区间，那么这个区间的start肯定是两个区间的start中大的那个，
    // 相应的，相交区间的end就是两个区间中较小的end，
    // 可以分别把它们的大start和小end取出来，然后看这两个边界是否可以形成一个交叉区间，
    // 然后，这两个区间当中，end更小的那个，肯定不可能再跟其他区间形成另一个相交区间了，
    // 因为它的区间已经完全被更大的end包围了，那么就把这个end更小的区间的指针向后移动，
    // 指向下一个区间
    // 注意end较大的那个区间不能移动，因为它有可能会跟end较小的区间的下一个区间继续有相交
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 存储最终相交区间
        List<int[]> res = new ArrayList<>();
        // 双指针指向各自的区间
        int i = 0;
        int j = 0;
        // 两边同时都有剩余的区间，才可能形成相交区间
        while (i < firstList.length && j < secondList.length) {
            // 假设当前指向的两个区间可以形成相交区间
            // 那么相交区间的左侧就是两个区间中较大的start，右侧是较小的end，
            // 计算出这个相交区间的头和尾
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            // 判断这个头和尾是不是一个合法的区间，也就是之前的假设是否成立，是否可以形成相交区间
            // 如果可以则加入结果
            if (left <= right) {
                res.add(new int[] {left, right});
            }
            // 无论是否可以，都需要把其中一个区间向后移动，
            // 移动的区间应当是end较小的那一个
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[0][0]);
    }
}
// @lc code=end

