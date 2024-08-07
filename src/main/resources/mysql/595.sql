# 595. Big Countries
# https://leetcode.cn/problems/big-countries/
Create table If Not Exists World
(
    name       varchar(255),
    continent  varchar(255),
    area       int,
    population int,
    gdp        bigint
);

# solution
select name, area, population
from World
where area > 3000000
   or population > 25000000;