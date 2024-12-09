/*
 * @lc app=leetcode.cn id=556 lang=java
 *
 * [556] 下一个更大元素 III
 */

// @lc code=start
class Solution {
    public int nextGreaterElement(int n) {
        // 记要交换的两个数字分别是 i 和 j,其中 i 是更高位
        // 首先如果交换两个位置可以变得更大
        // 那么后面低位的 j 肯定比前面位置上的数字 i 大
        // 这样才能做到交换后高位数字变大使得整个数字变大
        // 其次如果要使得变大后的数字尽量小
        // 那么交换的这个位置应该尽量靠后,也就是更低位
        // 那么应当从后往前找
        // 也可以得出 i 应当是 从后往前第一个下降的数字
        // 这样 i 是第一个可以跟后面交换后变得更大的数字
        // i 右边的数字(不包括 i )是越来越小的
        // 在 i 右边找到最小且大于 i 的就是 j
        // 交换 i 和 j 使得高位变大,
        // 同时还需要让高位后边的部分是最小
        // 后续的低位是降序排列, 翻转后形成升序排列
        // 自然就是同样的数字可以形成的最小数字了
        // 即使 i 和 j 交换,也不影响交换后高位右边的那部分的规律
        // 比如 12385764
        // 首先找到从右往左第一个下降点 5 作为 i
        // 然后可以看到 5 右边的 764 都是下降的
        // 找到比 i 大的最小值 6 作为 j
        // 交换 i 和 j, 12386754
        // 也不影响交换后 754 依然是下降的
        // 把下降部分翻转形成 457
        // 最后答案是 12386457
        
        // 将数字转为字符数组，方便操作
        char[] digits = Integer.toString(n).toCharArray();
        int len = digits.length;

        // 从右往左找到第一个下降点 i
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // 如果没有找到下降点，说明当前数字已经是最大值，返回 -1
        if (i < 0) {
            return -1;
        }

        // 从右往左找到第一个比 digits[i] 大的最小数字 j
        int j = len - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // 交换 i 和 j
        swap(digits, i, j);

        // 翻转 i 之后的部分，使其最小化
        reverse(digits, i + 1, len - 1);

        // 转换为数字并检查是否溢出
        long result = Long.parseLong(new String(digits));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    // 交换字符数组中的两个位置
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 反转字符数组的指定区间
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }
}
// @lc code=end

