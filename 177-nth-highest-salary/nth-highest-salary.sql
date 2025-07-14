CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
BEGIN
    SELECT salary INTO result
  FROM (
    SELECT DISTINCT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
    FROM employee
  )
  WHERE rnk = N;


    RETURN result;
END;