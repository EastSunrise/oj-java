# 181. Employees Earning More Than Their Managers
# https://leetcode.cn/problems/employees-earning-more-than-their-managers/
Create table If Not Exists Employee
(
    Id        int,
    Name      varchar(255),
    Salary    int,
    ManagerId int
);

# solution
select E.Name as Employee
from Employee E
         left join Employee M on E.ManagerId = M.Id
where E.Salary > M.Salary;