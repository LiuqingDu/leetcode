/*
 * @lc app=leetcode.cn id=1539 lang=java
 *
 * [1539] 第 k 个缺失的正整数
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        // 缺失的正整数一定 >= k
        // 数组中每出现一个 <= k 的数字, 意味着少了一个缺失的数字, 此时k+1
        // 另一种理解方式:
        // 可以假象构建了一个“缺失元素”数组：[1,2..k]，这个数组长度固定为 k，最后返回数组最后一个元素，也就是第 k 个元素。
        // 遍历 arr 如果有比 k 小的，要从这个数组中剔除，但是为了保证长度不变，就需要 k++ 补一个元素
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            }
        }
        return k;
    }
}
// @lc code=end

