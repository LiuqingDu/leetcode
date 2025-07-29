/*
 * @lc app=leetcode.cn id=1385 lang=java
 *
 * [1385] 两个数组间的距离值
 */

// @lc code=start
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // 先排序,然后二分查找
        Arrays.sort(arr2);
        int count = 0;
        // 对于arr1中的每个元素，它以d上下扩展出一个范围
        // 看arr2中是否存在一个元素在这个范围内
        // 使用二分查找来提高效率, 记arr2的中间位置mid
        // 看arr2[mid]是否在arr1[i]-d和arr1[i]+d之间
        // 如果在范围内,则不满足条件,跳过
        // 如果不在, 则要看mid的左区间和右区间哪个区间可能出现在范围内的数
        // 如果arr2[mid]比arr1[i]+d还大, 而右区间比mid还大,那么就说明右区间的数都不可能在范围内, 需要在左区间找
        // 同理如果arr2[mid]比arr1[i]-d还小, 需要在右区间找
        for (int i = 0; i < arr1.length; i++) {
            // 二分查找看是否存在一个数字在范围内
            int left = 0, right = arr2.length - 1;
            boolean isValid = true;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 如果arr2[mid]在范围内,则不满足条件
                if (arr2[mid] <= arr1[i] + d && arr2[mid] >= arr1[i] - d) {
                    isValid = false;
                    break;
                } else if (arr2[mid] < arr1[i] - d) {
                    // 如果arr2[mid]小于arr1[i]-d, 那么左区间的数都不可能在范围内
                    // 需要在右区间找
                    left = mid + 1;
                } else if (arr2[mid] > arr1[i] + d) {
                    // 如果arr2[mid]大于arr1[i]+d, 那么右区间的数都不可能在范围内
                    // 需要在左区间找
                    right = mid - 1;
                }
            }
            // 这里有可能是跳出来的,也可能是遍历完了left>right
            if (isValid) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

