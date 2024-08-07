# 262. Trips and Users
# https://leetcode.cn/problems/trips-and-users/
Create table If Not Exists Trips
(
    id         int,
    client_id  int,
    driver_id  int,
    city_id    int,
    status     ENUM ('completed', 'cancelled_by_driver', 'cancelled_by_client'),
    request_at varchar(50)
);
Create table If Not Exists Users
(
    users_id int,
    banned   varchar(50),
    role     ENUM ('client', 'driver', 'partner')
);

# solution
select t.request_at as Day, round(avg(if(t.status = 'completed', 0, 1)), 2) as `Cancellation Rate`
from Trips t
         left join Users a on t.client_id = a.users_id
         left join Users b on t.driver_id = b.users_id
where a.banned = 'No'
  and b.banned = 'No'
  and t.request_at between '2013-10-01' and '2013-10-03'
group by t.request_at