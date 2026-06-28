/*
 * @lc app=leetcode.cn id=907 lang=java
 *
 * [907] 子数组的最小值之和
 */

// @lc code=start
class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;
        // 使用 long 防止乘法溢出
        long sum = 0;
        long MOD = 1000000007;
        
        // 创建一个新数组，左右两端加上哨兵 0
        int[] extArr = new int[n + 2];
        System.arraycopy(arr, 0, extArr, 1, n);
        extArr[0] = 0;
        extArr[n + 1] = 0;
        
        // 栈中保存的是数组的下标
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < extArr.length; i++) {
            // 当遇到当前元素比栈顶元素小时，说明栈顶元素的右边界找到了
            while (!stack.isEmpty() && extArr[i] < extArr[stack.peek()]) {
                int curIdx = stack.pop(); // 当前要结算的元素下标
                int leftIdx = stack.peek(); // 当前元素的左边界下标
                int rightIdx = i; // 当前元素的右边界下标
                
                // 计算以 extArr[curIdx] 为最小值的子数组数量
                long count = (long) (curIdx - leftIdx) * (rightIdx - curIdx);
                
                // 累加贡献值值
                sum = (sum + count * extArr[curIdx]) % MOD;
            }
            stack.push(i);
        }
        
        return (int) sum;
    }
}
// @lc code=end

