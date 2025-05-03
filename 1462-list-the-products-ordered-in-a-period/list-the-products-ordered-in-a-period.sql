SELECT 
    p.product_name      AS product_name,
    SUM(o.unit) AS unit
FROM 
    products p
JOIN 
    orders o ON p.product_id = o.product_id
WHERE 
    o.order_date BETWEEN DATE '2020-02-01' AND DATE '2020-02-29'
GROUP BY 
    p.product_name     
HAVING 
    SUM(o.unit) >= 100;
