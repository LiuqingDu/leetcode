/*
 * @lc app=leetcode.cn id=384 lang=java
 *
 * [384] 打乱数组
 */

// @lc code=start
class Solution {
    // 每一个元素与后续的元素（包括自己）中的一个进行交换
    // 就可以形成每个位置都是随机元素
    int[] nums;
    int n;
    Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
    }
    
    public int[] reset() {
        return this.nums;
    }
    
    public int[] shuffle() {
        int[] res = this.nums.clone();
        for (int i = 0; i < this.n; i++) {
            swap(res, i, i + this.random.nextInt(this.n - i));
        }

        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
// @lc code=end

