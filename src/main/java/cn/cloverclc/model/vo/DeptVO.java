package cn.cloverclc.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "按部门查询员工的结果VO")
public class DeptVO {
    @Schema(description = "员工姓名")
    private String empName; // 员工名称

    @Schema(description = "员工职位")
    private String job; // 职位

    @Schema(description = "雇佣时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8") // 保持时间格式一致性
    private Date hiredate; // 雇佣时间

    @Schema(description = "联系方式")
    private String contactInfo; // 联系方式（整合mobile和emergency_contact）

    @Schema(description = "上级员工姓名")
    private String managerName; // 上级员工姓名
}