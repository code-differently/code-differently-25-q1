SELECT * FROM media_items

SELECT type, COUNT(*) AS count
FROM media_items
GROUP BY type;

SELECT SUM (m.pages) AS total_pages_checked_out
FROM checked_out_items c 
JOIN media_items m ON c.item_id = m.id;

SELECT g.name, c.* 
FROM guests g
LEFT JOIN checked_out_items c ON g.email  = c.email

DROP TABLE library_users;

CREATE TABLE library_users (
    id TEXT PRIMARY KEY,
    email TEXT NOT NULL UNIQUE,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    password TEXT NOT NULL
);

INSERT INTO library_users (id, email, first_name, last_name, password)
VALUES
('1', 'jane@example.com', 'Jane', 'Doe', '$2a$10$8Sbo8w4UTo7PYYMRAfE8ieBaQYqDZV9AYw2x9AlFFeFZ3Y3q1TxMi'),
('2', 'john@example.com', 'John', 'Smith', '$2a$10$L8lWx.L3QhxiKyzYJCTi7uYTeKKbqElxRYHO6mGjc5Cfb5pY3HHQO'),
('3', 'olivia@example.com', 'Olivia', 'James', '$2a$10$kRrQ3YbeXYbXl9F6sUYOYOX5pK8flNOuNcByVRKz9ChfLYUM6ZKAe');

SELECT * FROM library_users;