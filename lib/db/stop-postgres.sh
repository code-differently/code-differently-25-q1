#!/bin/bash

# Print colorful message
echo -e "\033[0;33m[INFO] Stopping PostgreSQL database...\033[0m"

# Navigate to the script directory
cd "$(dirname "$0")"

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo -e "\033[0;31m[ERROR] Docker is not running. Please start Docker and try again.\033[0m"
    exit 1
fi

# Stop the PostgreSQL container
docker-compose down

# Check if the stop was successful
if [ $? -eq 0 ]; then
    echo -e "\033[0;32m[SUCCESS] PostgreSQL database stopped successfully.\033[0m"
else
    echo -e "\033[0;31m[ERROR] Failed to stop PostgreSQL database.\033[0m"
    exit 1
fi
