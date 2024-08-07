# 627. Swap Salary
# https://leetcode.cn/problems/swap-salary/
Create table If Not Exists Salary
(
    id     int,
    name   varchar(100),
    sex    char(1),
    salary int
);

# solution
update Salary
set sex=if(sex = 'f', 'm', 'f');