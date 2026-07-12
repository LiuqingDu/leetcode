/*
 * @lc app=leetcode.cn id=1313 lang=java
 *
 * [1313] 解压缩编码列表
 */

// @lc code=start
class Solution {
    public int[] decompressRLElist(int[] nums) {
        
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<nums.length;i=i+2){
                if(i+1<nums.length){
                    while(nums[i] !=0){
                        list.add(nums[i+1]);
                        nums[i]--;
                    }
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
// @lc code=end

