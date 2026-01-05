package cn.cloverclc.service.Impl;

import cn.cloverclc.dao.EmployeeDao;
import cn.cloverclc.model.entity.Employee;
import cn.cloverclc.model.vo.DeptVO;
import cn.cloverclc.model.vo.EmployeeVO;
import cn.cloverclc.service.EmpService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service

public class EmpServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements EmpService {


    @Override
    public IPage<EmployeeVO> selectEmployeePage(Integer current, Integer size) {
        Page<EmployeeVO> page = new Page<>(current, size);
        return this.baseMapper.selectEmployeePage(page);
    }

    @Override
    public IPage<DeptVO> selectDeptPage(Integer current, Integer size, Integer deptno) {
        Page<DeptVO> page = new Page<>(current, size);
        return this.baseMapper.selectEmployeeByDept(page, deptno);
    }


}
