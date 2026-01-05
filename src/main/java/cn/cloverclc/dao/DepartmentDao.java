package cn.cloverclc.dao;


import cn.cloverclc.model.entity.Department;
import cn.cloverclc.model.vo.DeptStatisticsVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface DepartmentDao extends BaseMapper<Department> {
    int migrateEmpWhenDeptDelete(Integer deptno,Integer unAssignDeptno);
    List<DeptStatisticsVO> getAllDeptStatistics(Integer deptno);
}
