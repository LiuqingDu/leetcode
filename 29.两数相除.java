/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        // 三种特殊情况
        // 被除数为最小值
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }

        // 除数为最小值
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            } else {
                return 0;
            }
        }

        // 被除数为 0
        if (dividend == 0) {
            return 0;
        }

        // 二分查找
        // 把所有正数变为负数，这样只需要考虑一种情况就是负数除以负数
        // 因为负数取值范围比正数大，所以把正数变为负数。-2^31 ~ 2^31-1

        // 记录是否需要把结果取反，当只有除数或者被除数中的一个被取反时，结果需要取反
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, res = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                res = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -res : res;
    }

    // 快速乘
    private boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z*y >= x 是否成立
        int res = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 res + add >= x
                if (res < x - add) {
                    return false;
                }
                res += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }

            z >>= 1;
        }
        return true;
    }
}
// @lc code=end

