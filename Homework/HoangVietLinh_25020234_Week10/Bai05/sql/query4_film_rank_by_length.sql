-- ============================================================
-- Bài 5 - Query 4: Xếp hạng phim theo thời lượng trong từng thể loại
-- Kỹ thuật: Window Function - RANK()
-- ============================================================
-- RANK() OVER (PARTITION BY ... ORDER BY ...):
--   PARTITION BY = chia nhóm (giống GROUP BY nhưng không gộp dòng)
--   ORDER BY     = sắp xếp trong mỗi nhóm
--   RANK()       = gán thứ hạng (1, 2, 3,...) - có thể trùng hạng

SELECT
    f.title                 AS film_title,
    c.name                  AS category_name,
    f.length                AS duration_minutes,
    RANK() OVER (
        PARTITION BY c.category_id      -- Chia nhóm theo thể loại
        ORDER BY f.length DESC          -- Sắp xếp giảm dần theo thời lượng
    )                       AS rank_in_category
FROM film f
    INNER JOIN film_category fc ON f.film_id = fc.film_id
    INNER JOIN category c       ON fc.category_id = c.category_id
ORDER BY c.name, rank_in_category;
