# Write your MySQL query statement below
select u1.user_id , count(distinct u1.follower_id) as followers_count from Followers u1 join Followers u2 on u1.user_id = u2.user_id group by (u1.user_id);