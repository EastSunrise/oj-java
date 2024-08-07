# 178. Rank Scores
# https://leetcode.cn/problems/rank-scores/
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
