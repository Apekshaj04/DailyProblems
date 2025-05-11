SELECT e.employee_id 
  FROM Employees e 
  LEFT JOIN Salaries s ON e.employee_id = s.employee_id
  WHERE s.salary IS NULL
  UNION
 SELECT s1.employee_id
   FROM Salaries s1
   LEFT JOIN Employees e1 ON e1.employee_id = s1.employee_id
  WHERE e1.name IS NULL