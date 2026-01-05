package cn.cloverclc.service.Impl;

import cn.cloverclc.annotation.LogRecord;
import cn.cloverclc.dao.DepartmentDao;
import cn.cloverclc.model.entity.Department;
import cn.cloverclc.model.vo.DeptStatisticsVO;
import cn.cloverclc.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class DeptServiceImpl extends ServiceImpl<DepartmentDao, Department> implements DeptService {
    private static final Integer UN_ASSIGN_DEPTNO = 0;
    @Override
    @Transactional(rollbackFor = Exception.class) // 开启事务，异常时回滚
    public boolean deleteByDept(Integer deptno) {
        // 1. 校验参数
        if (deptno == null || deptno.equals(UN_ASSIGN_DEPTNO)) {
            throw new IllegalArgumentException("无效的部门编号，无法删除未分配部门");
        }

        // 2. 校验部门是否存在
        Department dept = this.getById(deptno);
        if (dept == null) {
            throw new RuntimeException("部门不存在或已被删除");
        }

        // 3. 迁移该部门下所有员工：记录原部门+改为未分配
        int affectedRows =  this.baseMapper.migrateEmpWhenDeptDelete(deptno, UN_ASSIGN_DEPTNO);

        if (affectedRows <= 0) {
            throw new RuntimeException("迁移失败");
        }
        return this.removeById(deptno);
    }

    @Override
    public List<DeptStatisticsVO> getAllDeptStatistics(Integer deptno) {
        List<DeptStatisticsVO> deptStatisticsVO = this.baseMapper.getAllDeptStatistics(deptno);
        return deptStatisticsVO;
    }
}
