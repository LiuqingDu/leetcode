/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {

    // 树状数组
    // https://www.bilibili.com/video/BV1ce411u7qP/

    int[] a;
    int[] b;

    public NumArray(int[] nums) {

        int n = nums.length;
        this.a = new int[n];
        this.b = new int[n + 1];

        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        int dif = val - this.a[index];
        this.a[index] = val;
        int p = index + 1;
        while (p < this.b.length) {
            this.b[p] += dif;
            p += lowBit(p);
        }
    }
    
    public int sumRange(int left, int right) {
       return prefixSum(right) - prefixSum(left - 1);
    }

    private int prefixSum(int index) {
        int sum = 0;
        int p = index + 1;
        while (p > 0) {
            sum += this.b[p];
            p = p - lowBit(p);
        }
        return sum;
    }

    private int lowBit(int x) {
        return x & (-x);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

