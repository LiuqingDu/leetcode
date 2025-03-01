/*
 * @lc app=leetcode.cn id=690 lang=java
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    // dfs 和 bfs 都可以
    // 先把数据放到 map 里, 提高效率

    Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subId : subordinates) {
            total += dfs(subId);
        }
        return total;
    }
}
// @lc code=end

