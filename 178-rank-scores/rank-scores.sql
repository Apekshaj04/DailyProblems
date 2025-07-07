/* Write your PL/SQL query statement below */
select score,r as rank from (select score,dense_rank() over (order by score desc) as r from Scores) ;