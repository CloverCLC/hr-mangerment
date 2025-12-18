## 人事管理系统
## v0.2-snapshot
### 完成的功能
1. 员工管理基本功能实现
2. 添加了mybatis_plus
   修改了dept表,创建dept_deptno_seq序列并关联deptno 列,使deptno以10自增,方便后续添加部门
### 问题
1. MyBatis-Plus 与 Spring Boot 3.x 版本兼容性问题
   参考https://blog.csdn.net/qq_57682309/article/details/149295836解决
2. delete和insert方法不成功
   @Transactional(readOnly = true)只读写在了最外层
   外层删掉写到里面解决
3. status字段是枚举类型,用cast as解决
   status=CAST(#{status} AS emp_status)