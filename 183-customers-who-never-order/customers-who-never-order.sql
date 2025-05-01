/* Write your PL/SQL query statement below */
SELECT  name as Customers from Customers where id not in (select  c.id from Customers c,Orders o where c.id=customerId);