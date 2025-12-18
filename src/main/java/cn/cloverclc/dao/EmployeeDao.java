package cn.cloverclc.dao;
import cn.cloverclc.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
//    检索全部

    @Select("SELECT * FROM emp")
    List<Employee> selectAllEmployee();

    @Select("SELECT * FROM emp WHERE empno = #{empno};")
    Employee selectEmployeeByEmpno(Integer empno);
}
