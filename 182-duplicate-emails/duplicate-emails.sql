/* Write your PL/SQL query statement below */
SELECT distinct p1.email as Email from Person p1 , Person p2 where p1.email=p2.email and p1.id<>p2.id;