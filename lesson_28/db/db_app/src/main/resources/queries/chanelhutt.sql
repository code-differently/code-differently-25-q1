/*Count the media items by types*/
SELECT type, COUNT(*) AS count
FROM media_items
GROUP BY type;

SELECT SUM(pages) AS total_pages
FROM checked_out_items x
JOIN media_items y ON y.id = x.item_id;

SELECT g.email, g.name, g.type, 
GROUP_CONCAT(c.item_id) AS checked_out_items
FROM guests g   
LEFT JOIN checked_out_items c ON g.email = c.email   
GROUP BY g.email, g.name, g.type
LIMIT 5;

    


