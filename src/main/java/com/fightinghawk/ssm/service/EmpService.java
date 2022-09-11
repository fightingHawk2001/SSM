package com.fightinghawk.ssm.service;

import com.fightinghawk.ssm.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author fightingHawk Email: fightingHawk2001@outlook.com
 * @date 2022/9/9 15:49
 */
public interface EmpService {
    List<Emp> getAll();

    PageInfo<Emp> getEmpsByPage(Integer pageNum);

    void addEmp(Emp emp);

    Emp getEmpByEmpId(Integer empId);

    void updateEmp(Emp emp);

    void delEmp(Integer empId);
}
