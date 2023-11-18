/*
 * @lc app=leetcode.cn id=215 lang=javascript
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    /**
     * 堆排序
     * https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/836425/xie-gei-qian-duan-tong-xue-de-ti-jie-yi-kt5p2/
     */

    let swap = function(arr, i, j) {
        let temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    let maxHeapify = function(nums, i, heapSize) {
        // 左子节点
        let l = i*2+1;
        // 右子节点
        let r = i*2+2;
        let largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest !== i) {
            swap(nums, i, largest);
            // 由于父节点和子节点交换，可能导致子树不是大顶堆，需要重新调整一下
            // 继续调整下面的节点
            maxHeapify(nums, largest, heapSize);
        }
    }
    
    let buildMaxHeap = function(nums, heapSize) {
        // 从底部往上开始创建大顶堆
        for (let i = Math.floor(heapSize/2)-1; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    let heapSize = nums.length;
    // 创建大顶堆
    buildMaxHeap(nums, heapSize);
    // 依次把前k-1个元素放到末尾，然后把剩下的前半部分元素继续调整为大顶堆
    for (let i = nums.length - 1; i >= nums.length - k + 1; i--) {
        swap(nums, 0, i);
        heapSize--;
        maxHeapify(nums, 0, heapSize);
    }
    // 这样对顶就是第k个大元素了
    return nums[0];
};
// @lc code=end

