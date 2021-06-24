package Exs.easy;

import java.util.HashMap;
import java.util.List;

/**
 * @author wy
 * @date 2021/4/30 17:08
 */
// 690. 员工的重要性
public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    HashMap<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        if (employees.isEmpty()) return 0;
        if (map.size() == 0){
            for (Employee employee : employees) {
                map.put(employee.id, employee);
            }
        }
        int res = 0;
        Employee curr = map.get(id);
        res += curr.importance;
        for (Integer subordinate : curr.subordinates) {
            res += getImportance(employees, subordinate);
        }
        return res;
    }

}
