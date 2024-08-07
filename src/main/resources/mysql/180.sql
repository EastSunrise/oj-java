# 180. Consecutive Numbers
# https://leetcode.cn/problems/consecutive-numbers/
Create table If Not Exists Logs
(
    Id  int,
    Num int
);

# solution 1
# count the consecutive same numbers before (inclusive) current number
select distinct C.Num as ConsecutiveNums
from (select Num,
             case
                 when Num = @prev then @count := @count + 1
                 when @prev := Logs.Num then @count := 1
                 end as cnt
      from Logs,
           (select @prev := null, @count := 0) P) C
where C.cnt >= 3;

# solution 2
# numbers are consecutive if the offset between id and row_number() is the same
select distinct b.num as ConsecutiveNums
from (select a.Num as num, a.Id + 1 - row_number() over (partition by a.Num order by a.Id) as offset
      from Logs a) b
group by b.num, b.offset
having count(*) >= 3;