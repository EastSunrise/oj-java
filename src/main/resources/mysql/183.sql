# 183. Customers Who Never Order
# https://leetcode.cn/problems/customers-who-never-order/
Create table If Not Exists Customers
(
    Id   int,
    Name varchar(255)
);
Create table If Not Exists Orders
(
    Id         int,
    CustomerId int
);

# solution 1
select Name as Customers
from Customers
where Id not in (select distinct CustomerId from Orders);

# solution 2
select Name as Customers
from Customers C
where not exists(select 1 from Orders O where O.CustomerId = C.Id);
