package com.Macrohard.Controller;

import com.Macrohard.dao.EmployeeLabDao;
import com.Macrohard.dao.GeneralLabDao;
import com.Macrohard.entities.EoyAwardRecord;
import com.Macrohard.entities.GeneralSalaryRecord;
import com.Macrohard.entities.MyEmployee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class generalLabController {

    @GetMapping("/genss")
    public String mGenSIndex(Model model){

        List<GeneralSalaryRecord> mGens = new GeneralLabDao().getGeneralRecords();
        model.addAttribute("mGens",mGens);
        return "recordlab/queryGenS_listAll";
    }

    @GetMapping("/eoyas")
    public String mEoyAIndex(Model model){

        List<EoyAwardRecord> mEoyas = new GeneralLabDao().getEoyAwardRecords();
        model.addAttribute("Eoyas",mEoyas);
        return "recordlab/queryEoyA_listAll";
    }
}
