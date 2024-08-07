# 596. Classes More Than 5 Students
# https://leetcode.cn/problems/classes-more-than-5-students/
Create table If Not Exists Courses
(
    student varchar(255),
    class   varchar(255)
);

# solution
select c.class
from Courses c
group by c.class
having count(distinct c.student) >= 5;