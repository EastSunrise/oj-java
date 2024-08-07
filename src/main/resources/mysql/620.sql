# 620. Not Boring Movies
# https://leetcode.cn/problems/not-boring-movies/
Create table If Not Exists cinema
(
    id          int,
    movie       varchar(255),
    description varchar(255),
    rating      float(2, 1)
);

# solution
select id, movie, description, rating
from cinema
where description <> 'boring'
  and id & 1
order by rating desc;