/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start

class Solution {
    public int hIndex(int[] citations) {

        // 比较明显的解法是排序，然后依次比较当前的引用以及不少于它的数量
        // Arrays.sort(citations);
        // int n = citations.length;

        // // citations[i] 表示当前有多少个引用
        // // n - i 表示包含当前的以及它右边的总共有多少个元素
        // // 右边都是引用更大的
        // for (int i = 0; i < n; i++) {
        //     if (citations[i] >= n - i) {
        //         return n - i;
        //     }
        // }

        // return 0;


        // 二分法
        // h表示有多少篇，那么h的取值正好在下标范围内，把下标当作h来看
        // 取中间的下标当作h，然后遍历统计引用大于h的有多少篇，记为c
        // 如果c大于等于h，说明h小了，可以再大一点，h在右半部分
        // 反之h在左半部分

        int n = citations.length;
        int left = 0;
        // 左闭右开, 因为最终结果right可以等于n,比如[1]
        int right = n;
        
        // 因为右边是开，所以left和right不能相等，如果相等则结束判断
        while (left < right) {
            // 这里需要+1，因为下面有一个left = mid，
            // 而这里的mid实际上是取整而不会五入，也就是永远偏左，
            // 就会导致left==mid从而死循环，
            // 这里+1让它往右偏移，避免left==mid
            int mid = (left + right + 1) >> 1;
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (citations[i] >= mid) {
                    c++;
                }
            }

            if (c >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right;

    }
}
// @lc code=end

