# 175. Combine Two Tables
# https://leetcode.cn/problems/combine-two-tables/
Create table If Not Exists Person
(
    personId  int,
    firstName varchar(255),
    lastName  varchar(255)
);
Create table If Not Exists Address
(
    addressId int,
    personId  int,
    city      varchar(255),
    state     varchar(255)
);

# solution
SELECT p.firstName, p.lastName, a.city, a.state
FROM Person p
         LEFT JOIN Address a on p.personId = a.personId;
