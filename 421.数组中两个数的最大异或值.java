/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start

import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        // 假设 nums 里最大的数为 a
        // a 的二进制位有 x 位（忽略左侧所有的 0）
        // 那么此题的答案也不会超过 x 位
        // 答案可能的的最大值是 x 位均为 1
        // 如果要让答案尽可能大，那么就应该优先保证左边位尽量取 1
        // 首先从左侧第一位开始，这一位能不能取 1，
        // 取决于 nums 所有数在这第一位是否存在两个数，它们的异或等于 1
        // 如果存在，那么最终答案在这一位上就可以取 1，否则这一位只能取 0
        // 这里按照第一位可以取 1 的情况继续分析，那么继续第二位
        // 此时要继续验证第二位能不能是 1
        // 也就是说验证答案的前两位能不能是 11
        // 同理，要找两个数，它们异或后前两位应当是 11
        // 否则答案前两位只能是 10
        // 至于如何确认是否存在两个数异或后等于目标值
        // 可以用 lc1 two sum 的思路
        // a^b = target 的话，异或符合交换律，可以得出 a = b^target
        // 那么如果要找出是否存在 a^b = target，可以寻找是否存在一个数等于b^target

        // 先找到答案的最高位是哪里
        // 也就是 nums 里最大的数字的第一个 1 在哪里
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }
        // 找到最高位 1 在第几位
        // -1 表示还不确定 1 在哪里
        // 如果 max 是 1，那么这一轮最后 highBit = 0
        // 表示在第 0 位是 1
        int highBit = -1;
        while (max != 0) {
            max >>= 1;
            highBit++;
        }

        // 最终结果
        int res = 0;
        // 用来截取每一个数字的前部分
        // 截取出来的数字用来两两配对找出是否可以异或形成待定的答案
        int mask = 0;
        Set<Integer> set = new HashSet<>();
        // 检验每一位是不是可以是 1
        for (int i = highBit; i >= 0; i--) {
            set.clear();
            // 当前检验位置为 1，与原先的 mask 拼接起来
            // 形成前部全是 1，后面全是 0
            mask |= 1 << i;

            // res 是已经确定的最终答案，这里把新的一位置为 1
            // 形成 newres 表示这一轮尝试检验 newRes 是否可以实现
            int newRes = res | (1 << i);
            for (int n : nums) {
                // 这里是把数字后面置为 0，只保留前面几位，用来验证 target 是否可以存在
                n &= mask;
                // 用了 two sum 的思路，寻找是否存在 a 使得 a=target^b
                if (set.contains(newRes ^ n)) {
                    // 如果存在，说明 newRes 可以实现
                    // 更新 res
                    res = newRes;
                    break;
                }
                set.add(n);
            }
        }
        return res;
    }
}
// @lc code=end

