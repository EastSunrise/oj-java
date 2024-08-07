# 182. Duplicate Emails
# https://leetcode.cn/problems/duplicate-emails/
Create table If Not Exists Person
(
    Id    int,
    Email varchar(255)
);

# solution
select P.Email
from Person P
group by P.Email
having count(P.Id) > 1;