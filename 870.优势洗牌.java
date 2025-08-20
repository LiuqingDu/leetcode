/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 明显当nums1的某个元素如果比nums2的所有元素都小,那么这个数字就不能成为优势
        // 反过来如果nums2的某个元素比nums1的一些元素小,那么对应的nums1就可以有优势
        // 此时最优解是从nums1里找出一个比nums2的元素大的最小的数字作为优势数字
        // 这样剩下的更大的数字就可以用来对付更大的nums2的元素
        // 所以可以先排序,然后如果nums1的首个元素比nums2的首个元素还大,这两个就可以配对
        // 作为一组优势
        // 如果nums1的首个元素比nums2的首个元素小,那么这个元素就不能成为优势
        // 因为两个数组数量相等,当nums1有一个元素不能成为优势来配对时
        // 那么nums2的最后一个元素肯定也没法被优势了
        // 那么可以把nums1的首个元素和nums2的最后一个元素配对,占据一个没有优势的配对
        // 对于nums2可以用两个指针,指向首个和最后一个元素,对应可以被优势的和无法被优势的元素
        // 对于nums1可以用一个指针,指向首个元素用来配对
        // 注意到需要返回一个nums1的排列,是对应nums2的原数组的,一对优势元素配对是不能随便放置的
        // 所以还需要记录nums1和nums2的原始索引位置,用来还原对应的位置

        int n = nums1.length;
        Integer[] index1 = new Integer[n];
        Integer[] index2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            index1[i] = i;
            index2[i] = i;
        }
        // 对nums1和nums2进行排序, 这里排序的是索引数组
        // 每个索引对应的元素是从小到大的
        Arrays.sort(index1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(index2, (i, j) -> nums2[i] - nums2[j]);

        int[] result = new int[n];
        // 使用双指针来配对
        // left指向nums2的最小元素, right指向nums2的最大元素
        // index2[left]是nums2的最小元素的索引, index2[right]是nums2的最大元素的索引
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            // 这里比较的是nums1最小元素和nums2最小元素
            // 注意nums2的最小元素的位置是index2[left]
            if (nums1[index1[i]] > nums2[index2[left]]) {
                // 如果nums1的当前元素比nums2的当前元素大,则可以配对
                // 注意这里放置的位置应该按照nums2的这个元素所在的位置
                // 这个元素的位置是index2[left]
                result[index2[left]] = nums1[index1[i]];
                left++;
            } else {
                // 否则就把nums1的当前元素和nums2的最后一个元素
                // 注意这里放置的位置应该按照nums2的这个元素所在的位置
                // 这个元素的位置是index2[right]
                result[index2[right]] = nums1[index1[i]];
                right--;
            }
        }
        return result;
    }
}
// @lc code=end

