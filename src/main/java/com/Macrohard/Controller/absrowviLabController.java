package com.Macrohard.Controller;

import com.Macrohard.dao.AbsrOvwiLabDao;
import com.Macrohard.dao.EmployeeLabDao;
import com.Macrohard.entities.AbsRecord;
import com.Macrohard.entities.MyEmployee;
import com.Macrohard.entities.OvwRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class absrowviLabController {

    @GetMapping("/absrs")
    public String absRsIndex(Model model) {

        List<AbsRecord> mAbsrs = new AbsrOvwiLabDao().getAllAbsRecords();
        model.addAttribute("Absrs", mAbsrs);

        return "recordlab/queryAbsr_listAll";
    }

    @GetMapping("/absr")
    public String toAddAbsrPage() {

        return "recordlab/queryAbsr_addOne";
    }

    @PostMapping("/absr")
    public String addAbsr(AbsRecord absRecord) {

        System.out.println(absRecord);
        int res = new AbsrOvwiLabDao().insertOneAbsr(absRecord);
        if (res == 0) {
            System.out.println("insertion failure");
        }
        //FORWARD(转发)/REDIRECT(重定向) goto absrs
        return "redirect:/absrs";
    }

    @DeleteMapping("/absr/{id}+{mth}")
    public String deleteEmp(@PathVariable("id") Integer id,
                            @PathVariable("mth") Integer mth) {

        System.out.println(id + " - " + mth);
        int res = new AbsrOvwiLabDao().deleteOneAbsr(id, mth);
        if (res == 0) {
            System.out.println("delete failure");
        }

        //FORWARD(转发)/REDIRECT(重定向) goto memps
        return "redirect:/absrs";
    }


    @GetMapping("/ovwis")
    public String ovwIsIndex(Model model) {

        List<OvwRecord> mOvwis = new AbsrOvwiLabDao().getAllOvwRecords();
        model.addAttribute("Ovwis", mOvwis);

        return "recordlab/queryOvwi_listAll";
    }

    @GetMapping("/ovwi")
    public String toAddOvwiPage() {

        return "recordlab/queryOvwi_addOne";
    }

    @PostMapping("/ovwi")
    public String addOvwi(OvwRecord ovwRecord) {

        //no override toString()!
        System.out.println(ovwRecord);
        int res = new AbsrOvwiLabDao().insertOneOvwi(ovwRecord);
        if (res == 0) {
            System.out.println("insertion failure");
        }
        //FORWARD(转发)/REDIRECT(重定向) goto absrs
        return "redirect:/ovwis";
    }

    @DeleteMapping("/ovwi/{id}+{mth}+{type}")
    public String deleteEmp(@PathVariable("id") Integer id,
                            @PathVariable("mth") Integer mth,
                            @PathVariable("type") String type) {

        System.out.println(id + " - " + mth + " - " + type);
        int res = new AbsrOvwiLabDao().deleteOneOvwi(id, mth, type);
        if (res == 0) {
            System.out.println("delete failure");
        }

        //FORWARD(转发)/REDIRECT(重定向) goto memps
        return "redirect:/ovwis";
    }
}
