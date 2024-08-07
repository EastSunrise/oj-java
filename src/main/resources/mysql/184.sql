# 184. Department Highest Salary
# https://leetcode.cn/problems/department-highest-salary/
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
select D.Name as Department, E.Name as Employee, E.Salary
from Employee E
         left join Department D on E.DepartmentId = D.Id
where (E.DepartmentId, E.Salary) in (select E1.DepartmentId, max(E1.Salary) from Employee E1 group by E1.DepartmentId);
