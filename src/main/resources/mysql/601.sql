# 601. Human Traffic of Stadium
# https://leetcode.cn/problems/human-traffic-of-stadium/
Create table If Not Exists Stadium
(
    id         int,
    visit_date DATE NULL,
    people     int
);

# solution
with t as (select a.id, a.id - row_number() over (order by a.id) as offset
           from Stadium a
           where a.people >= 100)
select s.*
from Stadium s
         inner join (select t.id, count(*) over (partition by t.offset) as cnt
                     from t) a on a.id = s.id and a.cnt >= 3
order by s.visit_date;