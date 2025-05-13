SELECT COUNT(*) AS total_media
FROM media_items
GROUP BY type
ORDER BY type;


SELECT SUM(pages) AS total_pages
FROM checked_out_items x
JOIN media_items y ON y.id = x.item_id;


SELECT 

    g.name AS guest_name,
    g.email AS guest_email,
    g.type AS guest_type,
    coi.item_id AS check_id,
    coi.email,
    coi.due_date
FROM guests g
LEFT JOIN checked_out_items coi ON g.email = coi.email
LIMIT 5;