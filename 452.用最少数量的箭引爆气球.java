/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {

    // 类似435题找无重叠子区间
    // 这道题其实也是把气球宽度看作每一个区间，如果多个区间重叠了，
    // 它们就可以用一支箭打穿。
    // 实际上就是找所有重叠的区域有多少组
    // 当一个区域a最先结束时，依次判断其他区域是否跟这个区域a有重叠，
    // 直到有区域的左边界大于a的右边界，那么就意味着是一个跟a没有重叠的区域，
    // 也就是说需要多一支箭了

    public int findMinArrowShots(int[][] points) {
        int n = points.length;

        if (n == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                // 这里需要直接判断大小，而不能用前者减去后者
                // 因为有一个测试用例的两个数是int最大值和最小值，
                // 相减之后溢出了
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        // 至少需要一支箭
        int res = 1;
        // 判断最小重叠区域的右边界，或者说是最多子区间的每一个区间的右边界
        int right = points[0][1];

        for (int i = 1; i < n; i++) {
            int[] point = points[i];

            if (point[0] <= right) {
                // 如果这个区域跟之前的区域还在重叠，也就是它的左边界
                // 还在之前区域的右边界right之内，那么就可以用同一支箭打穿
                // 那么这里就什么也不做
            } else {
                // 否则就是出现了一个新的区域，跟之前的都不重叠，
                // 就需要多一支箭
                res++;
                right = point[1];
            }
        }

        return res;
    }
}
// @lc code=end

