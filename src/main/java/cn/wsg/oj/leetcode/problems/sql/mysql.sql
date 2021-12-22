# 175. Combine Two Tables (Easy)
# https://leetcode-cn.com/problems/combine-two-tables/
Create table Person
(
    PersonId  int,
    FirstName varchar(255),
    LastName  varchar(255)
);
Create table Address
(
    AddressId int,
    PersonId  int,
    City      varchar(255),
    State     varchar(255)
);
# solution
SELECT P.FirstName, P.LastName, A.City, A.State
FROM Person P
         LEFT JOIN Address A on P.PersonId = A.PersonId;


# 176. Second Highest Salary (Easy)
# https://leetcode-cn.com/problems/second-highest-salary/
Create table If Not Exists Employee
(
    Id     int,
    Salary int
);
# solution 1
select MAX(Salary) as SecondHighestSalary
from Employee
where Salary < (select MAX(Salary) from Employee);

# solution 2
select (select distinct Salary
        from Employee
        order by Salary desc
        limit 1,1) as SecondHighestSalary;


# 177. Nth Highest Salary (Medium)
# https://leetcode-cn.com/problems/nth-highest-salary/
# solution
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set N = N - 1;
    RETURN (
        select (select distinct Salary
                from Employee
                order by Salary desc
                limit N,1) as NthHighestSalary
    );
END;


# 178. Rank Scores (Medium)
# https://leetcode-cn.com/problems/rank-scores/
Create table If Not Exists Scores
(
    Id    int,
    Score DECIMAL(3, 2)
);
# solution 1
select Score, dense_rank() over (order by Score desc ) as `Rank`
from Scores;

# solution 2
# the number of distinct scores that larger than or equal to the target is its rank.
select A.Score, count(distinct B.Score) as `Rank`
from Scores A,
     Scores B
where A.Score <= B.Score
group by A.Id
order by `Rank`;


# 180. Consecutive Numbers (Medium)
# https://leetcode-cn.com/problems/consecutive-numbers/
Create table If Not Exists Logs
(
    Id  int,
    Num int
);
# solution
# count the consecutive same numbers before (inclusive) current number
select distinct C.Num as ConsecutiveNums
from (select Num,
             case
                 when Num = @prev then @count := @count + 1
                 when @prev := Logs.Num then @count := 1 end cnt
      from Logs,
           (select @prev := null, @count := 0) P) C
where C.cnt >= 3;


# 181. Employees Earning More Than Their Managers (Easy)
# https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/
Create table If Not Exists Employee
(
    Id        int,
    Name      varchar(255),
    Salary    int,
    ManagerId int
);
# solution
select E.Name as Employee
from Employee E
         left join Employee M on E.ManagerId = M.Id
where E.Salary > M.Salary;


# 182. Duplicate Emails (Easy)
# https://leetcode-cn.com/problems/duplicate-emails/
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


# 183. Customers Who Never Order (Easy)
# https://leetcode-cn.com/problems/customers-who-never-order/
Create table If Not Exists Customers
(
    Id   int,
    Name varchar(255)
);
Create table If Not Exists Orders
(
    Id         int,
    CustomerId int
);
# solution 1
select Name as Customers
from Customers
where Id not in (select distinct CustomerId from Orders);

# solution 2
select Name as Customers
from Customers C
where not exists(select 1 from Orders O where O.CustomerId = C.Id);


# 184. Department Highest Salary (Medium)
# https://leetcode-cn.com/problems/department-highest-salary/
Create table If Not Exists Employee
(
    Id           int,
    Name         varchar(255),
    Salary       int,
    DepartmentId int
);
Create table If Not Exists Department
(
    Id   int,
    Name varchar(255)
);
# solution
select D.Name as Department, E.Name as Employee, E.Salary
from Employee E,
     Department D
where E.DepartmentId = D.Id
  and (E.DepartmentId, E.Salary) in (select E1.DepartmentId
                                          , max(E1.Salary)
                                     from Employee E1
                                     group by E1.DepartmentId);


# 185. Department Top Three Salaries (Hard)
# https://leetcode-cn.com/problems/department-top-three-salaries/
Create table If Not Exists Employee
(
    Id           int,
    Name         varchar(255),
    Salary       int,
    DepartmentId int
);
Create table If Not Exists Department
(
    Id   int,
    Name varchar(255)
);
# solution todo


# 196. Delete Duplicate Emails (Easy)
# https://leetcode-cn.com/problems/delete-duplicate-emails/
# solution
# cache the table before deleting
delete
from Person P
where not exists(select P1.Id
                 from (select min(P0.Id) as Id
                       from Person P0
                       group by P0.Email) P1
                 where P1.Id = P.Id);


# 197. Rising Temperature (Easy)
# https://leetcode-cn.com/problems/rising-temperature/
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


# 262. Trips and Users (Hard)
# https://leetcode-cn.com/problems/trips-and-users/
Create table If Not Exists Trips
(
    Id         int,
    Client_Id  int,
    Driver_Id  int,
    City_Id    int,
    Status     ENUM ('completed', 'cancelled_by_driver', 'cancelled_by_client'),
    Request_at varchar(50)
);
Create table If Not Exists Users
(
    Users_Id int,
    Banned   varchar(50),
    Role     ENUM ('client', 'driver', 'partner')
);
# solution todo


# 595. Big Countries (Easy)
# https://leetcode-cn.com/problems/big-countries/
Create table If Not Exists World
(
    name       varchar(255),
    continent  varchar(255),
    area       int,
    population int,
    gdp        int
);
# solution
select name, area, population
from World
where area > 3000000
   or population > 25000000;


# 596. Classes More Than 5 Students (Easy)
# https://leetcode-cn.com/problems/classes-more-than-5-students/
Create table If Not Exists courses
(
    student varchar(255),
    class   varchar(255)
);
# solution
select class
from courses
group by class
having count(distinct student) >= 5;


# 601. Human Traffic of Stadium (Hard)
# https://leetcode-cn.com/problems/human-traffic-of-stadium/
Create table If Not Exists stadium
(
    id         int,
    visit_date DATE NULL,
    people     int
);
# solution todo


# 620. Not Boring Movies (Easy)
# https://leetcode-cn.com/problems/not-boring-movies/
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


# 626. Exchange Seats (Medium)
# https://leetcode-cn.com/problems/exchange-seats/
Create table If Not Exists seat
(
    id      int,
    student varchar(255)
);
# solution
select (case
            when id & 1 and (select count(*) from seat) = id then id
            when id & 1 then id + 1
            else id - 1 end) as id,
       student
from seat
order by id;


# 627. Swap Salary (Easy)
# https://leetcode-cn.com/problems/swap-salary/
create table if not exists salary
(
    id     int,
    name   varchar(100),
    sex    char(1),
    salary int
);
# solution
update salary
set sex=if(sex = 'f', 'm', 'f');


# 1179. Reformat Department Table (Easy)
# https://leetcode-cn.com/problems/reformat-department-table/
Create table If Not Exists Department
(
    id      int,
    revenue int,
    month   varchar(5)
);
# solution todo



