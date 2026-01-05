package cn.cloverclc.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "部门汇总统计VO")
public class DeptStatisticsVO {
    @Schema(description = "部门编号")
    private Integer deptno; // 部门编号（关联对应部门）

    @Schema(description = "部门名称")
    private String dname; // 部门名称（可选，关联dept表查询）

    @Schema(description = "员工总数")
    private Integer empTotal; // 员工总数（该部门下所有员工，含离职）

    @Schema(description = "部门总薪资")
    private BigDecimal totalSal; // 总薪资（所有员工sal字段总和）

    @Schema(description = "部门平均薪资")
    private BigDecimal avgSal; // 平均薪资（总薪资/员工总数，保留2位小数）

    @Schema(description = "部门最高薪资")
    private BigDecimal maxSal; // 最高薪资（sal字段最大值）

    @Schema(description = "部门最低薪资")
    private BigDecimal minSal; // 最低薪资（sal字段最小值）

    @Schema(description = "部门总佣金")
    private BigDecimal totalComm; // 总佣金（所有员工comm字段总和，兼容null）

    @Schema(description = "在职人数")
    private Integer onDutyTotal; // 在职人数（员工status为在职状态，需匹配你的EmpStatus枚举）

    @Schema(description = "经理人数")
    private Integer managerTotal; // 经理人数（员工job为经理相关职位，如'MANAGER'）
}