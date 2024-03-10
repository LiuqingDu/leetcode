/*
 * @lc app=leetcode.cn id=137 lang=javascript
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {

    // 看数字的二进制
    // 把只出现一次的数字记为x，
    // 如果x的一个二进制位是0，那么所有数字的这个二进制位上，1的个数就是3的倍数
    // 如果x的一个二进制位是1，那么所有数字的这个二进制位上，1的个数是除以3余1
    // 统计每一个位上有多少个1，根据%3的余数来判断x的这个位上是1还是0

    let res = 0;

    // 判断二进制每一位
    for (let i = 0; i < 32; i++) {
        // 计数
        let count = 0;
        // 遍历每一个数
        for (let num of nums) {
            // 向右移动i位（把第i位右边的去掉），然后跟1进行与运算（第i位左边置0），就可以提取出来第i位
            if (num >> i & 1 === 1) {
                count++;
            }
        }

        // 判断这个位上的1的个数
        if (count % 3 === 1) {
            // 如果余1，说明x的这个位置上也是1
            // 把1向左移动到这个位置上，然后或运算把这个1合并到res中
            res = res | 1 << i;
        }
    }

    return res;

};
// @lc code=end

