# 185. Department Top Three Salaries
# https://leetcode.cn/problems/department-top-three-salaries/
Create table If Not Exists Employee
(
    Id           int,
    Name         varchar(255),
    Salary       int,
    DepartmentId int
);
Create table If Not Exists Department
(
    Id   int,
    Name varchar(255)
);

# solution
select d.Name as Department, t.Name as Employee, t.Salary
from (select e.Id,
             e.Name,
             e.DepartmentId,
             e.Salary,
             dense_rank() over (partition by e.DepartmentId order by e.Salary desc) as dr
      from Employee e) t
         left join Department d on t.DepartmentId = d.Id
where t.dr <= 3