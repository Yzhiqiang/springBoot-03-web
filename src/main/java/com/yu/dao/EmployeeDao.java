package com.yu.dao;


import com.yu.pojo.Department;
import com.yu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 16:05 2021/9/6
 * @Modified By:
 */
@Repository
public class EmployeeDao {
    public static Map<Integer, Employee> employeeMap= null;
    @Autowired
    private DepartmentDao departmentDao;

    static
    {
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(1001, new Employee(1001, "AA", "22222@qq.com", 1, new Department(100, "教学部")));
        employeeMap.put(1002, new Employee(1002, "BB", "33333@qq.com", 1, new Department(101, "市场部")));
        employeeMap.put(1003, new Employee(1003, "CC", "44444@qq.com", 2, new Department(102, "教研部")));
        employeeMap.put(1004, new Employee(1004, "DD", "55555@qq.com", 2, new Department(103, "运营部")));
        employeeMap.put(1005, new Employee(1005, "EE", "66666@qq.com", 2, new Department(104, "后勤部")));
    }
    private static Integer initId = 1006;
    public void save(Employee employee)
    {
        if(employee.getId() == null)
        {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentByid(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll()
    {
        return employeeMap.values();
    }

    public Employee getEmployeeByid(Integer id)
    {
        return employeeMap.get(id);
    }

    public void delete(Integer id)
    {
        employeeMap.remove(id);
    }
}
