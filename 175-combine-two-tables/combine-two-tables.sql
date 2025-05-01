/* Write your PL/SQL query statement below */
SELECT p.firstName AS FirstName,P.lastName  AS LastName,a.city AS City,a.state AS State from PERSON p  LEFT JOIN ADDRESS a ON p.personId = a.personId;