-- ============================================================
-- Bài 5 - Query 1: Top 5 thể loại phim có doanh thu cao nhất
-- Kỹ thuật: JOIN cơ bản + Aggregation (SUM, COUNT)
-- ============================================================
-- Chuỗi JOIN: category → film_category → inventory → rental → payment
-- Mỗi lần thuê phim tạo 1 bản ghi payment → SUM(amount) = tổng doanh thu

SELECT
    c.name                  AS category_name,
    SUM(p.amount)           AS total_revenue,
    COUNT(r.rental_id)      AS total_rentals
FROM category c
    INNER JOIN film_category fc ON c.category_id = fc.category_id
    INNER JOIN film f           ON fc.film_id = f.film_id
    INNER JOIN inventory i      ON f.film_id = i.film_id
    INNER JOIN rental r         ON i.inventory_id = r.inventory_id
    INNER JOIN payment p        ON r.rental_id = p.rental_id
GROUP BY c.category_id, c.name
ORDER BY total_revenue DESC
LIMIT 5;
