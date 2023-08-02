/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start

class Solution {
    // [1,2]的组合有[[],[1],[2],[1,2]]
    // 可以观察出，[1,2,3]的组合比[1,2]多的东西
    // 实际上{是把原先[1,2]的组合先复制一份，然后在这个基础上，给每一个复制出来的组合都加上3}，
    // 这样操作出来的组合就是比[1,2]多的组合
    // 那么可以依次叠加计算出每个数字多出来的组合
    // 先添加空组合，然后在此基础上算出有1的组合（复制空组合，在新空组合基础上加上1，再跟原先的空组合混合）
    // 然后再算有2的组合（在上一步基础上，复制所有组合，每个新组合里塞进2，再跟上一步的混合）

    // public List<List<Integer>> subsets(int[] nums) {
    //     // 存储最终结果
    //     List<List<Integer>> res = new LinkedList<List<Integer>>();
    //     // 先把空组合加进去
    //     res.add(new LinkedList<Integer>());

    //     // 依次循环每个数字
    //     for (int i = 0; i < nums.length; i++) {
    //         // 不能直接修改res，应当把res复制一份出来，在复制出来的那一份里面加上新数字
    //         // ，所以先建立一个临时的列表存储本轮因为这个新增的数字导致的新增的组合
    //         List<List<Integer>> dup = new LinkedList<List<Integer>>();
    //         for (List<Integer> li : res) {
    //             // 先把原先的组合依次复制出来
    //             List<Integer> tmp = new LinkedList<Integer>(li);
    //             // 复制出来的组合里加上新数字
    //             tmp.add(nums[i]);
    //             // 新组合添加到临时列表去
    //             dup.add(tmp);
    //         }
    //         // 把临时列表（因为这个新数字产生的新组合列表）加到结果中
    //         res.addAll(dup);
    //     }
    //     return res;
    // }

    // 方法二：回溯
    // 回溯就是不断尝试各种选择组合，这一种选择组合试到头就返回上一步换成其他选择继续
    // 注意这里不允许重复，所以1，2选择完以后，下次走到第一个选项为2的时候就不能在第二个选择选1了
    // 因此这里每一层选择都只能选择当前选项及之后的选项，不重复选择背后已经选过的组合

    // 最终结果列表
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    // 当前拼出来的组合
    List<Integer> cur = new LinkedList<Integer>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 这个回溯方法的意思是，从nums[start]开始往后依次选择一个数字并尝试
    private void backtrack(int[] nums, int start) {
        // 只要是一个组合，都需要加入结果中
        // 此时cur还不包含当前的nums[start]，只是上一步的结果
        // 第一次进来的时候正好也可以把空组合加入结果
        res.add(new LinkedList<Integer>(cur));

        // 从当前位置开始往后依次尝试每一个数字
        // 只考虑后面的而不考虑当前元素前面的数字，可以避免重复
        for (int i = start; i < nums.length; i++) {
            // 把当前数字加入拼出来的组合中
            cur.add(nums[i]);
            // 继续尝试剩下的位数
            backtrack(nums, i + 1);
            // 当前数字开头的已经尝试完，从选择中删除当前数字，下一轮循环会尝试下一个数字
            cur.remove(cur.size() - 1);
        }

    }

}
// @lc code=end

