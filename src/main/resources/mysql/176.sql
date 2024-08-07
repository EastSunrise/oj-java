# 176. Second Highest Salary
# https://leetcode.cn/problems/second-highest-salary/
Create table If Not Exists Employee
(
    id     int,
    salary int
);

# solution 1
select MAX(e.salary) as SecondHighestSalary
from Employee e
where e.salary < (select MAX(t.salary) from Employee t);

# solution 2
select (select distinct salary
        from Employee
        order by salary desc
        limit 1,1) as SecondHighestSalary;
