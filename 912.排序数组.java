/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    // 快排，思路是：随机取一个元素作为基准数，把剩下的元素分为两部分，一部分比基准小，一部分比基准大
    // 递归处理两部分

    // 具体操作：选取一个数字作为基准（比如第一个数字），然后将剩下的数字分为两部分，
    // 前半部分比基准小，后半部分比基准大，找到这两部分的分界处（取前半部分的最后一个数的位置）
    // 然后把基准（第一个数）与分界处（前半部分最后一个数）交换，
    // 这样基准数前面的就都是比基准小的，后面都是比基准大的，也就是把基准数放到了正确的位置上
    // 递归处理前后两部分

    // TODO: 固定取第一个元素作为基准数的话，对于已经排序的数组的效率不佳，随机取一个元素效果更好，待后续补充
    public int[] sortArray(int[] nums) {

        return quickSort(nums, 0, nums.length - 1);
    }

    // 对nums中索引为[left, right]的元素进行快排
    private int[] quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 找到基准数，这里取第一个
        int pivot = nums[left];
        int i = left;
        int j = right;

        while(i != j) {
            // 两头的指针向中间靠拢，指针停下来的时候:
            // 如果没有相遇，则右指针指向比基数小的，左指针指向比基数大的，交换两数，继续向中间循环
            // 如果相遇了，则它们指向的是最后一个比基数小的，
            //      因为是优先移动右指针，相遇的话肯定是右指针先占住最终位置，这个位置就是刚好比基数小的
            //      需要跟基数（也就是nums[left]）交换一下
            //      这样操作完了之后，基数就正好处于分割左右两部分的正确位置上

            // 右指针向左，找到右侧第一个比基数小的数
            while(nums[j] >= pivot && i < j) {
                j--;
            }

            // 左指针向右，找到左侧第一个比基数大的数
            while(nums[i] <= pivot && i < j) {
                i++;
            }

            // 交换两数
            swap(nums, i, j);

            // 继续循环，向中间靠拢，直到指针相遇
        }

        // 指针相遇时，指针指向的数字是最后一个比基数小的，跟基数交换一下
        swap(nums, i, left);

        // 递归处理左右两部分
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

