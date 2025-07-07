#!/bin/bash

# Print colorful message
echo -e "\033[0;32m[INFO] Starting PostgreSQL database...\033[0m"

# Navigate to the script directory
cd "$(dirname "$0")"

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo -e "\033[0;31m[ERROR] Docker is not running. Please start Docker and try again.\033[0m"
    exit 1
fi

# Start the PostgreSQL container
docker-compose up -d

# Wait for PostgreSQL to be healthy
echo -e "\033[0;33m[INFO] Waiting for PostgreSQL to be ready...\033[0m"
attempt=0
max_attempts=30

while [ $attempt -lt $max_attempts ]; do
    if docker-compose exec postgres pg_isready -U postgres > /dev/null 2>&1; then
        echo -e "\033[0;32m[SUCCESS] PostgreSQL is ready!\033[0m"
        echo -e "\033[0;34m
Connection Information:
  Host:     localhost
  Port:     5432
  Username: postgres
  Password: postgres
  Database: mydb
  
Connect with psql: psql -h localhost -U postgres -d mydb
\033[0m"
        exit 0
    fi
    
    attempt=$((attempt+1))
    echo -e "\033[0;33m[INFO] Waiting for database to be ready... ($attempt/$max_attempts)\033[0m"
    sleep 1
done

echo -e "\033[0;31m[ERROR] Failed to connect to PostgreSQL after $max_attempts attempts.\033[0m"
echo "Check container logs with: docker-compose logs postgres"
exit 1
