SELECT 
COUNT(*) As count
FROM media_items
GROUP BY type;

SELECT 
SUM(pages) as total_pages_checked_out
FROM checked_out_items c 
JOIN media_items m
ON c.item_id = m.id;

SELECT 
g.email,
g.name, 
GROUP_CONCAT(c.item_id) AS checked_out_items
FROM
guests g 
LEFT JOIN
checked_out_items c ON g.email = c.email
GROUP BY
g.email, g.name, g.type;

