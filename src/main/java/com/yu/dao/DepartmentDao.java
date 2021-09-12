package com.yu.dao;

import com.yu.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 15:58 2021/9/6
 * @Modified By:
 */
@Repository
public class DepartmentDao {
    //模拟数据库
    private static Map<Integer, Department> departmentMap = null;
    static
    {
        departmentMap = new HashMap<Integer, Department>();    //创建一个部门表
        departmentMap.put(100, new Department(100,"教学部"));
        departmentMap.put(101, new Department(101,"市场部"));
        departmentMap.put(102, new Department(102,"教研部"));
        departmentMap.put(103, new Department(103,"运营部"));
        departmentMap.put(104, new Department(104,"后勤部"));
    }

    //数据库操作

    //获取所有部门的信息
    public Collection<Department> getDepartments()
    {
        return departmentMap.values();
    }

    //通过id得到部门
    public Department getDepartmentByid(int id)
    {
        return departmentMap.get(id);
    }

}
