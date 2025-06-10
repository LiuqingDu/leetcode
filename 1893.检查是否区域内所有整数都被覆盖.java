/*
 * @lc app=leetcode.cn id=1893 lang=java
 *
 * [1893] 检查是否区域内所有整数都被覆盖
 */

// @lc code=start
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // 比较容易想到的就是根据每个 range, 把这个区间内的每一个数字的 count 都+1
        // 最后再检查 [left, right] 之间每一个数字的 count 是否均不小于 1
        // 这种方式复杂度为 O(n*l) 其中 n 为 ranges 长度, l 为区间[left, right]范围
        // 还有一种复杂度为 O(n+l) 的方法, 差分法
        // 差分法的每一个数字表示它与前者的差值
        // 对于每一个 range, 实际上是把区间内的所有数字的 count+1, 改为用差分法表示的话
        // 就是对于区间的第一个数字的count+1, 对于区间右侧第一个数字的count-1
        // 这表示: 区间第一个数字与它前面的数字的 count 差值增加 1, 
        // 区间右侧第一个数字的 count 与它前面的数字(区间最后一个数字)的 count 差值减少 1

        // 差分数组
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }
        // 前缀和
        int curr = 0;
        for (int i = 1; i <= 50; ++i) {
            curr += diff[i];
            if (i >= left && i <= right && curr <= 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

