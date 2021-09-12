package com.yu.controller;

import com.yu.dao.DepartmentDao;
import com.yu.dao.EmployeeDao;
import com.yu.pojo.Department;
import com.yu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 22:02 2021/9/6
 * @Modified By:
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model)
    {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model)
    {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    //员工增加页面
    @PostMapping("/emp")
    public String addEmp(Employee employee)
    {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

//    去员工的修改页面
    @RequestMapping("/update/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model)
    {
        Employee employee = employeeDao.getEmployeeByid(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee)
    {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
