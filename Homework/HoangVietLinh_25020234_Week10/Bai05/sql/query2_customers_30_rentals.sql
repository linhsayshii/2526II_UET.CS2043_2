-- ============================================================
-- Bài 5 - Query 2: Khách hàng thuê hơn 30 phim
-- Kỹ thuật: GROUP BY + HAVING (lọc sau khi nhóm)
-- ============================================================
-- HAVING khác WHERE ở chỗ:
--   WHERE lọc TRƯỚC khi nhóm (lọc từng dòng)
--   HAVING lọc SAU khi nhóm (lọc theo kết quả aggregate)

SELECT
    CONCAT(c.first_name, ' ', c.last_name)  AS customer_name,
    c.email                                  AS email,
    COUNT(r.rental_id)                       AS total_rentals
FROM customer c
    INNER JOIN rental r ON c.customer_id = r.customer_id
GROUP BY c.customer_id, c.first_name, c.last_name, c.email
HAVING COUNT(r.rental_id) > 30
ORDER BY total_rentals DESC;
