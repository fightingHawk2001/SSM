package com.fightinghawk.ssm.mapper;

import com.fightinghawk.ssm.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fightingHawk Email: fightingHawk2001@outlook.com
 * @date 2022/9/9 16:23
 */
public interface EmpMapper {
    Emp selectEmpByEmpId(@Param("empId") Integer empId);

    List<Emp> selectAllEmp();

    void insertEmp(Emp emp);

    void updateEmpById(Emp emp);

    void deleteEmpById(@Param("empId") Integer empId);
}
