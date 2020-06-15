package com.Macrohard.Controller;

import com.Macrohard.dao.DepartmentDao;
import com.Macrohard.dao.EmployeeDao;
import com.Macrohard.dao.EmployeeLabDao;
import com.Macrohard.entities.Department;
import com.Macrohard.entities.DeptRecord;
import com.Macrohard.entities.Employee;
import com.Macrohard.entities.MthRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class employeeLabController {

    @GetMapping("/qbMths")
    public String qbMthsIndex(){
        return "employeelab/querySal_mth_select";
    }

    //Query all employees and return to list page
    @GetMapping("/qbMth/{mth}")
    public String toMthShowPage(@PathVariable("mth") String mth,Model model){

        List<MthRecord> records = new EmployeeLabDao().getMthSalaryRecords(mth);

        //put result in request field
        model.addAttribute("mrecords",records);

        //thymeleaf auto makeup "/templates/xxxxx.html"
        return "employeelab/querySal_mth_show";
    }

    @GetMapping("/qbDepts")
    public String qbDeptsIndex(){
        return "employeelab/querySal_dept_select";
    }

    //Query all employees and return to list page
    @GetMapping("/qbDept/{dept}")
    public String toDeptShowPage(@PathVariable("dept") String dept,Model model){

        List<DeptRecord> records = new EmployeeLabDao().getDeptMthRecord(dept);

        //put result in request field
        model.addAttribute("mdrecords",records);

        //thymeleaf auto makeup "/templates/xxxxx.html"
        return "employeelab/querySal_dept_show";
    }
}
