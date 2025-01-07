/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        // 为了使最后的数字最大,那么要尽量保持高位不变,尽量变低位的
        // 那么最多有多少位高位可以不变呢?取决于从高到低哪一位开始数字变小了
        // 从高位到低位,第一个满足 arr[i]>arr[i+1] 的,把 arr[i] 减 1, 并把后续位置为 9 即可
        // 比如 n = 1234321
        // res   = 1233999
        // 这是因为当第一次出现数字变小时,也就是不满足单调递增时,
        // 就需要从这个最后一个高位开始调整数字了,使得整体满足单调递增
        // 但这里有一个情况需要处理
        // 如果 arr[i]-1 之后导致它跟 arr[i-1] 这一位不形成单调递增了怎么办
        // 比如 n = 1233332, 如果不处理则是 1233329
        // 但正确 res = 1229999
        // 注意到我们应当递归处理,如果新的 arr[i]-1 比 arr[i-1] 小, 则继续递归
        // 把 arr[i-1] -1, 然后把 arr[i] 置为 9
        // 这样递归下去其实可以发现我们递归的都是同一个数字,也就是arr[i]之前的与 arr[i] 相同的数字
        // 这个数字也是在下降前的最大数字
        // 我们记录这个最大数字第一次出现的位置,从这个位置到下降前都是同一个数字,都需要处理
        

        char[] arr = (n + "").toCharArray();
        // 记录最大值和出现的位置
        int max = -1, idx = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            // 如果出现了更大的数字才更新
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
            // 如果出现了下降
            if (arr[i] > arr[i + 1]) {
                // 下降前的那个最大数字的起始索引位置进行-1
                arr[idx] -= 1;
                // 其余位置为 9
                for(int j = idx + 1;j < arr.length;j++) {
                    arr[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(arr));

    }
}
// @lc code=end

