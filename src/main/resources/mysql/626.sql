# 626. Exchange Seats
# https://leetcode.cn/problems/exchange-seats/
Create table If Not Exists Seat
(
    id      int,
    student varchar(255)
);

# solution 1
select (case
            when id & 1 and (select count(*) from Seat) = id then id
            when id & 1 then id + 1
            else id - 1 end) as id,
       student
from Seat
order by id;

# solution 2
select t.id,
       if(t.id & 1, lead(t.student, 1, t.student) over (order by t.id),
          lag(t.student, 1) over (order by t.id)) as student
from Seat t
order by t.id;