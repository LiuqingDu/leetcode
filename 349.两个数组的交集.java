/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 一个数组或者set或者map记录nums1出现的元素
        // 这里用数组记录，因为结果去重，所以nums1元素最多记1，表示存在即可
        int[] arr = new int[1001];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i: nums1) {
            arr[i] = 1;
        }
        for (int i: nums2) {
            arr[i]--;
            if (arr[i] == 0) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

