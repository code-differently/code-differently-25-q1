<!-- Returns count of media items by type -->
SELECT type, COUNT(*) AS count
FROM media_items
GROUP BY type;

