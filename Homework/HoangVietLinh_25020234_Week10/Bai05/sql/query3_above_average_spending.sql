-- ============================================================
-- Bài 5 - Query 3: Khách hàng chi tiêu trên mức trung bình
-- Kỹ thuật: CTE (Common Table Expression) + Subquery
-- ============================================================
-- Bước 1 (CTE): Tính tổng chi tiêu của TỪNG khách hàng
-- Bước 2 (Subquery): Tính mức chi tiêu TRUNG BÌNH
-- Bước 3: Lọc những ai > trung bình

WITH customer_spending AS (
    -- CTE: Tính tổng chi tiêu mỗi khách hàng
    SELECT
        c.customer_id,
        CONCAT(c.first_name, ' ', c.last_name)  AS customer_name,
        c.email,
        SUM(p.amount)                            AS total_spent
    FROM customer c
        INNER JOIN payment p ON c.customer_id = p.customer_id
    GROUP BY c.customer_id, c.first_name, c.last_name, c.email
)
SELECT
    customer_name,
    email,
    total_spent
FROM customer_spending
WHERE total_spent > (
    -- Subquery: Tính mức trung bình của tất cả khách hàng
    SELECT AVG(total_spent) FROM customer_spending
)
ORDER BY total_spent DESC;
