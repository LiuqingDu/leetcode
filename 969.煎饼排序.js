/*
 * @lc app=leetcode.cn id=969 lang=javascript
 *
 * [969] 煎饼排序
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {number[]}
 */
var pancakeSort = function(arr) {
    let reverse = (arr, end) => {
        for (let i = 0, j = end; i < j; i++, j--) {
            let temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // 两次翻转就可以把索引为 i 的元素放到末尾
    // 1. 翻转[0, i]
    // 2. 翻转[0, n-1]，其中n为数组长度
    // 这样可以实现把指定元素放在末尾
    // 每次把前面最大的元素放在这些元素的末尾，
    // 然后减少排序的范围
    let res = [];

    // 从末尾开始，每新的一轮减少一个末尾元素
    for (let n = arr.length; n > 1; n--) {
        // 从第一个元素开始找最大值
        let index = 0;
        for (let i = 1; i < n; i++) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }
        // 如果最大值是最后一个了，那么就不需要翻转了
        // 跳过这轮
        if (index === n - 1) {
            continue;
        }

        reverse(arr, index);
        reverse(arr, n - 1);
        res.push(index + 1);
        res.push(n);
    }
    
    return res;

};
// @lc code=end

