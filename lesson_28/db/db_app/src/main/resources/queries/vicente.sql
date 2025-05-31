-- Active: 1748708794846@@127.0.0.1@3306
-- 1)
SELECT type, COUNT(*) FROM media_items GROUP BY type;
-- 2) 
SELECT SUM(pages) FROM media_items 
JOIN checked_out_items ON media_items.id = checked_out_items.item_id;
-- 3) 
SELECT name, title, item_id FROM guests 
LEFT JOIN checked_out_items ON checked_out_items.email = guests.email 
LEFT JOIN media_items ON checked_out_items.item_id = media_items.id;

-- Add a new table called library_users to the SQLite database that stores a user's id (UUID formatted string), email, 
-- first name, last name, and a password (bcrypt encoded string). Add a model and repository that loads the users into the 
-- LibraryDataModel (see LibraryGuestModel and LibraryGuestRepository as examples). Populate the database with a few users.
CREATE TABLE library_users (
    user_id VARCHAR(36) PRIMARY KEY,
    email VARCHAR(320),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255)
);

INSERT INTO library_users (user_id, email, first_name, last_name, password) VALUES
('550e8400-e29b-41d4-a716-446655440000', 'vicente@test.com', 'Vicente', 'Test', '$2a$10$7QdB9JXzXTZr1NmVvl3poOT8bq/tBzSvWj7cXzDYPnS6X7CayVuR6'),
('6c9e34ff-57a1-4f3a-9f09-0a3e7461df7a', 'kobe@test.com', 'Kobe', 'Bryant', '$2a$10$zRUj9hULhZlUz3EK2ky9W.B7IYqJS/8RqDhL6FfRMLV7e9UK9uRzO'),
('a7d1f0c5-7d42-4a89-bf18-962dd0c6a1cd', 'michael@example.com', 'Michael', 'Jordan', '$2a$10$JqwHo6iW4aB7B7A0sXPuBOu9k6fi9i5cz2HgL7tss62tWcyeKkpqG'),
('2f1d38f4-1692-4d28-958e-8a71c792f239', 'lebron@example.com', 'Lebron', 'James', '$2a$10$U1FQtWZdyq6guoZq6k3L6u2nZ8kgWqW6UlIYQGeF3By6F5XLZbP5e'),
('b3c47289-ff23-4ee1-b3a1-0c9e271ac9b4', 'stephen@example.com', 'Steph', 'Curry', '$2a$10$Q9rZw3J6RRIwJtzPf4X0fej4KY6iHLFej1ZJXJZ6nTrYp1MZNoeKa');

