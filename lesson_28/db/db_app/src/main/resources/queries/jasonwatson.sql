-- 1. Count of media items by type
SELECT type, COUNT(*) AS count
FROM media_items
GROUP BY type;

-- 2. Sum of total pages checked out by guests
SELECT SUM(mi.page_count) AS total_pages_checked_out
FROM checked_out_items coi
JOIN media_items mi ON coi.media_item_id = mi.id;

-- 3. Show all guests and any corresponding checked out items
SELECT g.*, coi.*
FROM guests g
LEFT JOIN checked_out_items coi ON g.id = coi.guest_id;
