# 一条update sql的执行流程
![img.png](update_sql执行流程.png)
<br>
其中浅色是InnoDB内部执行的，深色是执行器执行的

## 两阶段提交（prepare和commit）为了保证binlog和redo log的一致

