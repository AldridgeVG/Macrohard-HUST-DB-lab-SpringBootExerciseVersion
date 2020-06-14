package com.Macrohard.Controller;

import com.Macrohard.dao.DepartmentDao;
import com.Macrohard.dao.EmployeeDao;
import com.Macrohard.entities.Department;
import com.Macrohard.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Collection;

@Controller
public class employeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //Query all employees and return to list page
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //put result in request field
        model.addAttribute("emps",employees);

        //thymeleaf auto makeup "/templates/xxxxx.html"
        return "employee/list";
    }

    //check the addEmp button in list.htm send "/emp" request
    @GetMapping("/emp")
    public String toAddEmpPage(Model model){

        //get all optional Dept info to show in page
        Collection<Department> departments= departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //goto "/tmplates/employee/add.html"
        return "employee/add";
    }

    //here /emp request is under Postmapping, differs from upper one
    //SpringMVC will automatically bind properties of param and obj (param属性名 和 javaBean入参的属性名一致)
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        //System.out.println("NewEmp: "+employee);
        employeeDao.save(employee);

        //FORWARD(转发)/REDIRECT(重定向) goto emp list.html(emps)
        return "redirect:/emps";
    }

    //First get employee by id and show back in edit page
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){

        //same as toAddPage
        Collection<Department> departments= departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //query this emp and save to model
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //goto edit page
        return "employee/edit";
    }

    //edit emp info, requiring submit he's id
    @PutMapping("/emp")
    public String editEmp(Employee employee){

        System.out.println("EditEmp: "+employee);
        employeeDao.save(employee);

        //FORWARD(转发)/REDIRECT(重定向) goto emp list.html(emps)
        return "redirect:/emps";
    }
}
