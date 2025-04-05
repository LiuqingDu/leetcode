/*
 * @lc app=leetcode.cn id=1460 lang=java
 *
 * [1460] 通过翻转子数组使两个数组相等
 */

// @lc code=start
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // 从题目中也能猜出只要两个数组的元素相同那么就可以达成目标
        // 证明: 对于长度大于 1 的数组,翻转一次或者两次即可实现任意两个元素互换位置
        // 如果要互换的元素相邻,则直接翻转即可
        // 如果不相邻,记为元素 a 和 b, 先把包含 a 和 b 及它们之间的元素翻转
        // 然后只翻转 ab 之间的元素(不含 ab)
        // 这样就实现了 a 和 b 互换位置
        // 既然可以实现任意两个元素互换,则也可以实现从 arr 变换为 target 数组, 只要它们元素相同

        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
// @lc code=end

