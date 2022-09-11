package com.fightinghawk.ssm.controller;

import com.fightinghawk.ssm.pojo.Emp;
import com.fightinghawk.ssm.service.EmpService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author fightingHawk Email: fightingHawk2001@outlook.com
 * @date 2022/9/9 15:17
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    // 查询员工分页信息
    @GetMapping("/page/{pageNum}")
    public String getPageEmps(@PathVariable("pageNum") Integer pageNum, Model model) {
        PageInfo<Emp> page = empService.getEmpsByPage(pageNum);
        model.addAttribute("page", page);
        return "list";
    }

    // 通过id查询员工信息
    @GetMapping("/{empId}")
    public String getEmp(@PathVariable("empId") Integer empId, Model model) {
        Emp emp = empService.getEmpByEmpId(empId);
        // 将查询到的员工信息存入请求域以供修改页面数据回显
        model.addAttribute("emp", emp);
        // 转发到修改页面
        return "edit";
    }

    // 增加员工信息
    @PostMapping("/add")
    public String add(Emp emp) {
        empService.addEmp(emp);
        return "redirect:/emp/page/1";
    }

    // 通过id修改员工信息
    @PutMapping("/update")
    public String update(Emp emp) {
        empService.updateEmp(emp);
        return "redirect:/emp/page/1";
    }

    // 通过id删除员工信息
    @DeleteMapping("/delete/{empId}")
    public String delete(@PathVariable("empId") Integer empId) {
        empService.delEmp(empId);
        return "redirect:/emp/page/1";
    }
}
