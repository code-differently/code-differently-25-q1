#!/bin/bash

# Print colorful message
echo -e "\033[0;34m[INFO] Checking PostgreSQL database status...\033[0m"

# Navigate to the script directory
cd "$(dirname "$0")"

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo -e "\033[0;31m[ERROR] Docker is not running. Please start Docker and try again.\033[0m"
    exit 1
fi

# Get container status
CONTAINER_ID=$(docker-compose ps -q postgres)

if [ -z "$CONTAINER_ID" ]; then
    echo -e "\033[0;33m[INFO] PostgreSQL container is not running.\033[0m"
    exit 0
fi

# Check if container is running
if docker ps -q --no-trunc | grep -q "$CONTAINER_ID"; then
    echo -e "\033[0;32m[INFO] PostgreSQL container is running.\033[0m"
    
    # Check if PostgreSQL is responsive
    if docker-compose exec postgres pg_isready -U postgres > /dev/null 2>&1; then
        echo -e "\033[0;32m[SUCCESS] PostgreSQL server is accepting connections.\033[0m"
        
        # Display container info
        echo -e "\033[0;34m\nContainer Information:\033[0m"
        docker ps --filter "id=$CONTAINER_ID" --format "ID: {{.ID}}\nName: {{.Names}}\nStatus: {{.Status}}\nPorts: {{.Ports}}\n"
        
        echo -e "\033[0;34m\nConnection Information:
  Host:     localhost
  Port:     5432
  Username: postgres
  Password: postgres
  Database: mydb
  
Connect with psql: psql -h localhost -U postgres -d mydb\033[0m"
    else
        echo -e "\033[0;31m[WARNING] PostgreSQL container is running but the server is not accepting connections.\033[0m"
    fi
else
    echo -e "\033[0;31m[ERROR] PostgreSQL container exists but is not running.\033[0m"
    echo "Container status:"
    docker ps -a --filter "id=$CONTAINER_ID" --format "ID: {{.ID}}\nName: {{.Names}}\nStatus: {{.Status}}\n"
fi
