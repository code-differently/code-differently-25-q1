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
