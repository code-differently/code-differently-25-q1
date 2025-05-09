-- Query 1: Count of media items by type
SELECT 
    type,
    COUNT(*) as item_count
FROM media_items
GROUP BY type
ORDER BY type;

-- Query 2: Sum of total pages checked out by guests
SELECT 
    SUM(pages) as total_pages_checked_out
FROM checked_out_items
WHERE guest_id IS NOT NULL;

-- Query 3: All guests and their corresponding checked out items
SELECT 
    g.id as guest_id,
    g.name as guest_name,
    g.email as guest_email,
    g.phone as guest_phone,
    g.address as guest_address,
    coi.id as checked_out_item_id,
    coi.media_item_id,
    coi.checkout_date,
    coi.return_date,
    coi.pages
FROM guests g
LEFT JOIN checked_out_items coi ON g.id = coi.guest_id
ORDER BY g.id, coi.checkout_date; 