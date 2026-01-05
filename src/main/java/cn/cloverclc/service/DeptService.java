package cn.cloverclc.service;


import cn.cloverclc.model.entity.Department;
import cn.cloverclc.model.vo.DeptStatisticsVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface DeptService extends IService<Department> {
    boolean deleteByDept(Integer deptno);
    List<DeptStatisticsVO> getAllDeptStatistics(Integer deptno);
}
