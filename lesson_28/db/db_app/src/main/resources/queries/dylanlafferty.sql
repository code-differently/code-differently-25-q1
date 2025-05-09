-- 1. Count of media items by type
SELECT 
    type,
    COUNT(*) AS total
FROM
    media_items
GROUP BY
    type;

-- 2. Sum of total pages checked out by guests
SELECT
    SUM(pages) AS total_pages
FROM 
    media_items m 
JOIN 
    checked_out_items c ON m.id = c.item_id;

-- 3. All 5 guests and their corresponding checked-out items
SELECT 
    g.*,
    c.email, 
    item.title
FROM 
    guests g
LEFT JOIN
    checked_out_items c ON c.email = g.email
LEFT JOIN
    media_items item ON item.id = c.item_id;