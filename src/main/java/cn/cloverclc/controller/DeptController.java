package cn.cloverclc.controller;

import cn.cloverclc.annotation.LogRecord;
import cn.cloverclc.model.entity.Department;
import cn.cloverclc.model.vo.DeptStatisticsVO;
import cn.cloverclc.common.Result;
import cn.cloverclc.service.Impl.DeptServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dept")
@CrossOrigin(origins = "http://localhost:8081")
public class DeptController {
    @Resource
    private DeptServiceImpl deptService;
    @GetMapping("/DeptStatistics")
    public Result<List<DeptStatisticsVO>> getDeptStatisticsVO( @RequestParam(value = "id", required = false) Integer id) {
        List<DeptStatisticsVO> list = deptService.getAllDeptStatistics(id);
        return Result.success(list);
    }

    @PostMapping("/add")
    public Result<Void> add(@RequestBody Department dept){
        boolean result = deptService.save(dept);
        if(result){
            return Result.success();
        }
        return Result.error("添加失败");
    }

    @PutMapping("/del/{id}")
    @LogRecord
    public Result<Void> delDept(@PathVariable Integer id) {
        boolean result = deptService.deleteByDept(id);
        if (result) {
            return Result.success();
        }
        return Result.error("删除失败");
    }
}
