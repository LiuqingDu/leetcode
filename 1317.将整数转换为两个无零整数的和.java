/*
 * @lc app=leetcode.cn id=1317 lang=java
 *
 * [1317] 将整数转换为两个无零整数的和
 */

// @lc code=start
class Solution {
    public int[] getNoZeroIntegers(int n) {
        // 记可以拆分成 A + B 的形式
        // 其中 A 是每一位均为 9 的数字
        // 比如 11 拆为 9+2
        // 需要特殊处理的情况是 B 里含有 0
        // 比如 19 = 9 + 10
        // 这种情况下对 B 里每一个 0 都变为 1
        // 然后从 A 的对应位上减去 1
        // 比如 19 = 8 + 11

        int [] res = new int[2];
        //n <= 10 时单独讨论一下
        if(n <= 10) {
            res[0] = 1;
            res[1] = n - 1;
            return res;
        }

        //求数字n的十进制长度
        int length = (int)Math.log10(n);

        //数字res[0]中每一位都是9,res[1]是与res[0]互补的数
        res[0] = (int)Math.pow(10, length) - 1;
        res[1] = n - res[0];

        //判断res[1]中十进制某一位是否为0
        int temp = res[1];
        int index = 1;

        while(temp > 0) {
            //如果res[1]某一位为0，则res[1]该位加上1，res[0]该位减去1
            if(temp % 10 == 0) {
                res[0] -= index;
                res[1] += index;
            }
            index *= 10;
            temp = temp / 10;
        }

        return res;
    }
}
// @lc code=end

