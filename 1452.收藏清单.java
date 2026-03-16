/*
 * @lc app=leetcode.cn id=1452 lang=java
 *
 * [1452] 收藏清单
 */

// @lc code=start
class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        
        // 把每个列表转成 HashSet
        List<Set<String>> sets = new ArrayList<>();
        for (List<String> list : favoriteCompanies) {
            sets.add(new HashSet<>(list));
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            boolean isSubset = false;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                // 如果 j 的集合更大才可能包含 i
                if (sets.get(j).size() >= sets.get(i).size()) {
                    if (sets.get(j).containsAll(sets.get(i))) {
                        isSubset = true;
                        break;
                    }
                }
            }
            
            if (!isSubset) {
                res.add(i);
            }
        }
        
        return res;
    }
}
// @lc code=end

