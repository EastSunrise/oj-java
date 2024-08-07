# 197. Rising Temperature
# https://leetcode.cn/problems/rising-temperature/
Create table If Not Exists Weather
(
    Id          int,
    RecordDate  date,
    Temperature int
);

# solution
select W1.Id
from Weather W1
         left join Weather W2 on datediff(W1.RecordDate, W2.RecordDate) = 1
where W1.Temperature > W2.Temperature;