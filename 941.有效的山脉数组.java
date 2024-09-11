/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] arr) {
        // 分别从两侧向另一侧寻找山顶，判断山顶是不是同一个即可
        // 注意如果山顶在两端也不符合题意
        // 如果数组长度小于 3 也必然不符合

        int n = arr.length;
        if (n < 3) {
            return false;
        }

        int l = 0, r = n - 1;
        while (l < n - 1 && arr[l + 1] > arr[l]) {
            l++;
        }

        while (r > 0 && arr[r - 1] > arr[r]) {
            r--;
        }

        return l == r && l != n-1 && r != 0;
    }
}
// @lc code=end

