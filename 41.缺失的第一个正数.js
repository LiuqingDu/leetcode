/*
 * @lc app=leetcode.cn id=41 lang=javascript
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    
    let swap = function(arr, i, j) {
        let tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 题目意思是：数组里有一些数字，这些数字可能是负数、0、正数
    // 找出缺失的最小的正数
    // 我们把数组里的正数x拿出来，放到索引为x-1的位置上，
    // 这样数组里最多放1~n这些正数
    // 对于0和负数，就放在剩余的位置上
    // 这样再次遍历，当第一次遇到一个跟它位置不匹配的数，这个位置就是缺失的正数
    // 如果遍历完都没有返回，说明数组里正好是1~n,则返回n+1

    let n = nums.length;
    for (let i = 0; i < n; i++) {
        // 注意nums[i]可以等于n，因为它要放在nums[i]-1的地方，刚好在索引范围内
        // 这里必须用while，因为每次把旧的nums[i]放到对应位置后，新换来的nums[i]需要再检查一下
        // 如果新换来的还不符合，则依然需要置换，并再检查更新的那个
        // 注意这里最后一个条件是判断的当前位置的数字是否等于它正确位置上的数字，
        // 而不是判断当前索引是否是对应正确的索引
        // 因为如果是[1,1]这样的用例，判断索引的话会导致这两个元素不停置换死循环
        // 判断值的话可以避免死循环置换
        while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] !== nums[i]) {
            swap(nums, i, nums[i] - 1);
        }
    }

    for (let i = 0; i < n; i++) {
        if (nums[i] - 1 != i) {
            return i + 1;
        }
    }

    return n + 1;

};
// @lc code=end

