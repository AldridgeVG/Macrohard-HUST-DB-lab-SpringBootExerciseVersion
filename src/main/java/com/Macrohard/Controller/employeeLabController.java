package com.Macrohard.Controller;

import com.Macrohard.dao.DepartmentDao;
import com.Macrohard.dao.EmployeeDao;
import com.Macrohard.dao.EmployeeLabDao;
import com.Macrohard.entities.*;
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

    @GetMapping("/qbIDs")
    public String qbIDsIndex(Model mdoel){

        //get all empinfo in select page as option in list bar
        List<empIDNameSet> options = new EmployeeLabDao().getAllEmp();
        mdoel.addAttribute("empopt",options);

        return "employeelab/querySal_id_select";
    }

    //additional post-/qbID
    //empno from page will be automatically bind to ret.empno
    //used to get posted id and form get uri => forward to real show page
    @PostMapping("/qbID")
    public String forwardIDShow(empIDRet ret){

        //get number property and forward
        return "redirect:/qbID/"+ret.getEmpno();
    }

    @GetMapping("/qbID/{id}")
    public String toIDShowPage(@PathVariable("id") Integer id,Model model){

        //System.out.println(id);
        List<IDRecord> records = new EmployeeLabDao().getIDMthRecord(id);

        //put result in request field
        model.addAttribute("mirecords",records);

        //thymeleaf auto makeup "/templates/xxxxx.html"
        return "employeelab/querySal_id_show";
    }

    @GetMapping("/memps")
    public String mEmpIndex(Model model){

        List<MyEmployee> mEmps = new EmployeeLabDao().getAllMyEmp();
        model.addAttribute("mEmps",mEmps);
        return "employeelab/queryEmp_listAll";
    }

    @GetMapping("/memp")
    public String toAddEmpPage(){

        //goto "/tmplates/employee/add.html"
        return "employeelab/queryEmp_addOne";
    }

    @PostMapping("/memp")
    public String addEmp(MyEmployee memployee){

        System.out.println(memployee);
        int res = new EmployeeLabDao().insertOneEmp(memployee);
        if(res == 0){
            System.out.println("insertion failure");
        }
        //FORWARD(转发)/REDIRECT(重定向) goto memps
        return "redirect:/memps";
    }

}
