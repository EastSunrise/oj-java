# 177. Nth Highest Salary
# https://leetcode.cn/problems/nth-highest-salary/
Create table If Not Exists Employee
(
    Id     int,
    Salary int
);

# solution
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set N = N - 1;
    RETURN (select (select distinct Salary
                    from Employee
                    order by Salary desc
                    limit N,1) as NthHighestSalary);
END;