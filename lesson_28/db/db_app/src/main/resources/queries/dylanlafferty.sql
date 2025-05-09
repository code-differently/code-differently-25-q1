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
    media_items;

-- 3. All 5 guests and their corresponding checked-out items
SELECT 
    email,
    name AS value,
    'Guest Name' AS source
FROM 
    guests
UNION

SELECT
    c.email,
    m.title AS value,
    'Checked Out Title' AS source
FROM
    checked_out_items c
JOIN 
    media_items m ON m.id = c.item_id;
