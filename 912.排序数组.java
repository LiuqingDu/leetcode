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

    /*
     * 已更新为随机数的方法，看没有被注释的内容
     * ！！！！！！！！！！！！！！！！！！！！
     */
    
    // 对nums中索引为[left, right]的元素进行快排
    // private int[] quickSort(int[] nums, int left, int right) {
    //     if (left > right) {
    //         return null;
    //     }

    //     // 找到基准数，这里取第一个
    //     int pivot = nums[left];
    //     int i = left;
    //     int j = right;

    //     while(i != j) {
    //         // 两头的指针向中间靠拢，指针停下来的时候:
    //         // 如果没有相遇，则右指针指向比基数小的，左指针指向比基数大的，交换两数，继续向中间循环
    //         // 如果相遇了，则它们指向的是最后一个比基数小的，
    //         //      因为是优先移动右指针，相遇的话肯定是右指针先占住最终位置，这个位置就是刚好比基数小的
    //         //      需要跟基数（也就是nums[left]）交换一下
    //         //      这样操作完了之后，基数就正好处于分割左右两部分的正确位置上

    //         // 右指针向左，找到右侧第一个比基数小的数
    //         while(nums[j] >= pivot && i < j) {
    //             j--;
    //         }

    //         // 左指针向右，找到左侧第一个比基数大的数
    //         while(nums[i] <= pivot && i < j) {
    //             i++;
    //         }

    //         // 交换两数
    //         swap(nums, i, j);

    //         // 继续循环，向中间靠拢，直到指针相遇
    //     }

    //     // 指针相遇时，指针指向的数字是最后一个比基数小的，跟基数交换一下
    //     swap(nums, i, left);

    //     // 递归处理左右两部分
    //     quickSort(nums, left, i - 1);
    //     quickSort(nums, i + 1, right);

    //     return nums;
    // }

    // 已经更新为更优的方案，对于有大量相同数字的数组，原方法效率不高，随机抽取一个数字效率较高
    // 思路是分为三个区间，依次为小于，等于pivot，和大于的，用两个指针less和more标记三个区间的分界线
    private Random random = new Random();

    public int[] sortArray(int[] nums) {

        return quickSort(nums, 0, nums.length - 1);
    }

    // 对nums中索引为[left, right]的元素进行快排
    private int[] quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 随机一个[left, right]的数
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        // 找到基准数，这里取的实际上是随机的那个数，因为上面已经交换过了
        int pivot = nums[left];
        int less = left;
        int more = right + 1;
        int i = left + 1;
        // 小于nums[pivot]区间：[left + 1, less]
        // 等于nums[pivot]区间：[less + 1, i], 其中i = more - 1
        // 大于nums[pivot]区间：[more, right]

        while(i < more) {
            if (nums[i] < pivot) {
                // 如果这个数比基准数小，则less界限往右移动，意味着新的less指向的位置nums[less]可以用于放置这个小的数字
                less++;
                swap(nums, i, less);
                i++;
            } else if (nums[i] == pivot) {
                // 如果相等，则把i往右移动，此时less+1和i之间都是等于pivot的
                i++;
            } else if (nums[i] > pivot) {
                // 如果比基数大，则more界限往左移动，同理腾出的位置放置这个大的数字
                // 这里跟小于的逻辑不同的是，i不能++，因为交换过后，i指向的是原先more左移新收录进来的那个位置的数字，
                // 这个数字在i的右边，实际上还没有进行过比较，所以不能跳过，
                // 小于的那个逻辑，在less右移后，nums[less]指向的位置永远不会超过i，所以它指向的数字都是已经被i遍历过，也就是比较过的
                more--;
                swap(nums, i, more);
            }
        }

        // 指针相遇时，less指向的是最后一个小于基数的，把它与基数nums[left]交换，这样基数就放在正确位置了
        swap(nums, less, left);

        // 递归处理左右两部分
        quickSort(nums, left, less - 1);
        quickSort(nums, more, right);

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

