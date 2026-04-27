/*
 * @lc app=leetcode.cn id=2570 lang=java
 *
 * [2570] 合并两个二维数组 - 求和法
 */

// @lc code=start
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            int id1 = nums1[i][0], val1 = nums1[i][1];
            int id2 = nums2[j][0], val2 = nums2[j][1];

            if (id1 == id2) {
                // id相同，求和
                res.add(new int[]{id1, val1 + val2});
                i++;
                j++;
            } else if (id1 < id2) {
                res.add(new int[]{id1, val1});
                i++;
            } else {
                res.add(new int[]{id2, val2});
                j++;
            }
        }

        // 处理剩余部分
        while (i < nums1.length) {
            res.add(nums1[i++]);
        }

        while (j < nums2.length) {
            res.add(nums2[j++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
// @lc code=end

