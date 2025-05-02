/* Write your PL/SQL query statement below */
/* Write your PL/SQL query statement below */
SELECT name from SalesPerson where name NOT IN  (SELECT S.name FROM SalesPerson S  JOIN Orders O  ON S.sales_id = O.sales_id  JOIN Company C ON  O.com_id=C.com_id WHERE C.name='RED');