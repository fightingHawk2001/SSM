package com.fightinghawk.ssm.service.impl;

import com.fightinghawk.ssm.mapper.EmpMapper;
import com.fightinghawk.ssm.pojo.Emp;
import com.fightinghawk.ssm.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author fightingHawk Email: fightingHawk2001@outlook.com
 * @date 2022/9/9 15:49
 */
@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    private final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public List<Emp> getAll() {
        return empMapper.selectAllEmp();
    }

    @Override
    public PageInfo<Emp> getEmpsByPage(Integer pageNum) {
        // 开启分页插件
        PageHelper.startPage(pageNum, 5);
        // 查询所有员工信息
        List<Emp> emps = getAll();
        return new PageInfo<>(emps, 5);
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.insertEmp(emp);
    }

    @Override
    public Emp getEmpByEmpId(Integer empId) {
        return empMapper.selectEmpByEmpId(empId);
    }

    @Override
    public void updateEmp(Emp emp) {
        empMapper.updateEmpById(emp);
    }

    @Override
    public void delEmp(Integer empId) {
        empMapper.deleteEmpById(empId);
    }
}
