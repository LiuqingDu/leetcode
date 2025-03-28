/*
 * @lc app=leetcode.cn id=1089 lang=java
 *
 * [1089] 复写零
 */

// @lc code=start
class Solution {
    public void duplicateZeros(int[] arr) {
        // 双指针
        // 但如果从左往右的双指针,那么由于 0 要复写,就会出现
        // 未来的数据被覆盖掉(要求原数组原地修改)
        // 所以填充数据的话就需要倒着来
        // 先不填充数据从左往右做一次双指针
        // 目的是找到原数组的哪些数字是被保留下来的
        // 原数组 arr 索引 i, 结果数组记为 res 索引 j
        // 当然这里由于原地修改, arr 和 res 实际上是一回事
        // 只是表明一下不同的数据
        // 一开始两个指针先指向索引 0
        // 当 i 指向的元素不为 0, 则 i 和 j 前进一步, 走到下一个未处理元素上
        // 当 i 指向 0, 则 i 前进一步,j 前进两步,均指向下一个未处理的元素
        // 其中 j 出发前的位置就是 i 出发前的数据转移过去的第一个位置
        // 当 j 超出范围后,此时由于 i 和 j 都是指向下一个要处理的数据位置
        // 也就是说 i 的位置是不属于 res 里的
        // arr[i-1] 恰好是可以放到 res 里的最后一个元素
        // 那么此时把 i 和 j 都向左移动一个位置
        // 此时 i 指向最后一个元素, j 可能在数组内,也可能还在数组外
        // 此时把指针倒着来写就可以了, 可以避免覆盖未处理的数据
        // 对于 j 还处于数组外的话, 额外判断一下即可, 此时说明 i 指向 0, j 是复写两步出去的

        int n = arr.length, i = 0, j = 0;
        // 找到 i 和 j 最后出现的位置
        while (j < n) {
            if (arr[i] == 0) {
                j++;
            }
            i++;
            j++;
        }
        // i 和 j 都出去了,回退一步
        i--; j--;
        // 开始倒着来
        while (i >= 0) {
            // i 和 j 都指向还没处理的位置
            // 先把 i 的复制到 j 上
            if (j < n) {
                arr[j] = arr[i];
            }
            // 如果 i 指向 0, 则 j 多退一步进行复写
            // 注意这里 j 可能退到左侧边界外了
            // 比如原数组是[0], 则倒着来的话,j 多退一步就会出界
            // 所以要判断一下
            if (arr[i] == 0) {
                j--;
                if (j >= 0) {
                    arr[j] = 0;
                }
            }
            // 数据复制完了, 指针各退一步
            i--;
            j--;
        }
    }
}
// @lc code=end

