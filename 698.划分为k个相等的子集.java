/*
 * @lc app=leetcode.cn id=698 lang=java
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start
class Solution {

    // 解法二
    // 思考为把n个数字放到k个桶里，使得每个桶的和相等
    // 站在桶的角度去想，桶对于每一个数字，可以选择进桶，也可以选择不进桶
    // 回溯算法
    // public boolean canPartitionKSubsets(int[] nums, int k) {

    //     if (k > nums.length) {
    //         return false;
    //     }
    //     int sum = 0;
    //     for (int v : nums) {
    //         sum += v;
    //     }
    //     if (sum % k != 0) {
    //         return false;
    //     }

    //     // 每个桶的目标和
    //     int target = sum / k;
    //     // 记录每个数字是不是已经进桶了
    //     boolean[] used = new boolean[nums.length];

    //     Arrays.sort(nums);
    //     for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
    //         int temp = nums[i];
    //         nums[i] = nums[j];
    //         nums[j] = temp;
    //     }

    //     return backtrack(k, 0, nums, 0, used, target);
    // }

    // // 第k个桶想选择一个数字进桶，当前桶的和是bucket，目标值是target
    // private boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
    //     // k表示第几个桶，从1到k，0就是桶已经全部放满了
    //     // 因为不放满就不会换到下一个桶，所以每个桶都满了就表示满足题目，可以直接返回
    //     if (k == 0) {
    //         return true;
    //     }

    //     // 如果当前桶刚好满了，则换到下一个桶
    //     if (bucket == target) {
    //         return backtrack(k - 1, 0, nums, 0, used, target);
    //     }

    //     for (int i = start; i < nums.length; i++) {
    //         if (used[i]) {
    //             continue;
    //         }
    //         if (bucket + nums[i] > target) {
    //             continue;
    //         }
    //         used[i] = true;
    //         bucket += nums[i];
    //         if (backtrack(k, bucket, nums, start + 1, used, target)) {
    //             return true;
    //         }
    //         used[i] = false;
    //         bucket -= nums[i];

    //     }

    //     return false;
    // }


    // 解法一：
    // 思考为把n个数字放到k个桶里，使得每个桶的和相等
    // 站在数字的角度去想，每一个数组需要选择一个桶，然后把这个数字放进去
    // 这就是一个回溯算法
    // 注意回溯的时候有一个判断，如果当前数字放进桶里导致和超出目标值，那么就不能放进去
    // 这就是剪枝，避免进入不必要的子树中
    // 为了提高剪枝效率，可以让这个桶早一点满，也就是优先把大数放进去
    // 那么就需要先把数组按照从大到小排序
    public boolean canPartitionKSubsets(int[] nums, int k) {

        // 如果桶比数字多那么就放不满
        if (k > nums.length) {
            return false;
        }

        // 如果总和不能被k整除，那么也不能组成
        int sum = 0;
        for (int v : nums) {
            sum += v;
        }
        if (sum % k != 0) {
            return false;
        }

        // 从大到小排序
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 每个桶应该组成的目标和
        int target = sum/k;
        // 记录每个桶的和
        int[] bucket = new int[k];

        return backtrack(nums, 0, bucket, target);

    }

    private boolean backtrack(int[] nums, int start, int[] bucket, int target) {

        // 如果数字遍历完了，检查所有桶是不是都相等
        if (start == nums.length) {
            for (int i = 0; i < bucket.length; i++){
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        // 为当前这个数字找一个桶放进去
        for (int i = 0; i < bucket.length; i++) {
            // 如果这个数字放进去溢出了，就跳过
            if (bucket[i] + nums[start] > target) {
                continue;
            }

            // 把数字放到桶里
            bucket[i] += nums[start];
            // 如果满足要求则返回
            if (backtrack(nums, start+1, bucket, target)) {
                return true;
            }
            // 否则取出来尝试下一个桶
            bucket[i] -= nums[start];
            // 如果这是一个全新的桶，那么说明刚才这个数字跟任何其他数字都不能组成目标
            // 可以直接返回false
            if (bucket[i] == 0) {
                return false;
            }
        }

        // 找遍所有的桶都不行
        return false;
    }
}
// @lc code=end

