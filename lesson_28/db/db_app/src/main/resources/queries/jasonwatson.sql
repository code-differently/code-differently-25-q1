-- Count of media items by type
SELECT type, COUNT(*) AS count
FROM media_items
GROUP BY type;

-- Sum of total pages checked out by guests
SELECT SUM(mi.page_count) AS total_pages_checked_out
FROM checked_out_items coi
JOIN media_items mi ON coi.media_item_id = mi.id;

-- Guests with any checked out items
SELECT g.*, coi.*
FROM guests g
LEFT JOIN checked_out_items coi ON g.id = coi.guest_id;

-- Create library_users table
CREATE TABLE IF NOT EXISTS library_users (
    id TEXT PRIMARY KEY,
    email TEXT UNIQUE NOT NULL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    password TEXT NOT NULL
);

-- Insert sample users (replace with real UUIDs and bcrypt passwords)
INSERT INTO library_users (id, email, first_name, last_name, password) VALUES
('123e4567-e89b-12d3-a456-426614174000', 'alice@example.com', 'Alice', 'Smith', '$2b$12$abcdefg1exampleexampleexampleexample123456'),
('123e4567-e89b-12d3-a456-426614174001', 'bob@example.com', 'Bob', 'Johnson', '$2b$12$hijklmn2exampleexampleexampleexample654321'),
('123e4567-e89b-12d3-a456-426614174002', 'carol@example.com', 'Carol', 'Williams', '$2b$12$opqrstu3exampleexampleexampleexample789012');
