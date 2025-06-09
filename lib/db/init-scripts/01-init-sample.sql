-- Sample initialization script
-- This will run when the container first initializes

-- Create a sample table
CREATE TABLE IF NOT EXISTS sample_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Insert some sample data
INSERT INTO sample_table (name, description)
VALUES
    ('Sample 1', 'This is a sample record'),
    ('Sample 2', 'Another sample record');
    
-- Create a sample user (with limited privileges)
-- Uncomment if needed
/*
CREATE USER sampleuser WITH PASSWORD 'samplepass';
GRANT CONNECT ON DATABASE mydb TO sampleuser;
GRANT USAGE ON SCHEMA public TO sampleuser;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO sampleuser;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO sampleuser;
*/

-- Note: This script runs on database creation only. If you modify it,
-- you'll need to remove the postgres_data volume to see the changes:
-- docker volume rm db_postgres_data
