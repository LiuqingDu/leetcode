/*
 * @lc app=leetcode.cn id=380 lang=java
 *
 * [380] O(1) 时间插入、删除和获取随机元素
 */

// @lc code=start
class RandomizedSet {
    // 容易想到用 map 实现插入删除
    // 随机获取用 map 不太好，可以用数组
    // 两者结合可以实现
    // map 存储 val 和它在数组的下标
    // 增删从 map 操作，同时维护一份数组，保存 map里有的数据
    // 随机获取的时候从数组内随机一个
    // 为了 O(1) 复杂度，增删数组元素的时候不能从中间操作
    // 必须在数组的尾部操作，且数组容量不能扩大
    // 所以需要初始化就是一个最大的数组用来存储所有的数据
    // 增删不能在中间操作的话，那就需要按顺序从第一个位置开始依次放置数据
    // 增直接依次放置即可
    // 删除的话，应当用最后一个数据替换要删除的数据，然后把尾部指针往前移动一个
    // 比如[1,2,3]删除 2，应当用尾部的 3 去替换 2，然后把尾部指针向前移动

    int[] nums = new int[200000];
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int ind = -1;

    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        ind++;
        nums[ind] = val;
        map.put(val, ind);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.remove(val);
        // 如果删除的元素的下标不等于最后一个下标，
        // 那么准备用最后一个元素替换
        // 最后一个元素的下标替换为被删除的那个元素下标
        if (loc != ind) {
            map.put(nums[ind], loc);
        }
        nums[loc] = nums[ind];
        // 末尾指针向左移动，表示删除了一个
        ind--;
        return true;
    }
    
    public int getRandom() {
        return nums[random.nextInt(ind + 1)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

