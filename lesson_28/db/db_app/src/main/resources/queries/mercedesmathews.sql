SELECT
    type,
    COUNT(*) AS total
FROM
    media_items
GROUP BY
    type


SELECT
    SUM(pages) AS total_pages_checked
FROM
    checked_out_items a
    JOIN media_items b ON b.id = a.item_id


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
