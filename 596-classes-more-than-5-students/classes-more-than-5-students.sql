SELECT class
FROM (
    SELECT class, COUNT(*) AS total
    FROM Courses
    GROUP BY class
    HAVING COUNT(*) >= 5
);
