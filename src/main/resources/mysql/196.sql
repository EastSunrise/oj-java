# 196. Delete Duplicate Emails
# https://leetcode.cn/problems/delete-duplicate-emails/
Create table If Not Exists Person
(
    Id    int,
    Email varchar(255)
);

# solution 1
delete p1
from Person p1,
     Person p2
where p1.Email = p2.Email
  and p1.Id > p2.Id;

# solution 2
delete
from Person
where Id not in (select * from (select min(Id) from Person group by Email) t);
