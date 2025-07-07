# PostgreSQL Docker Setup

This directory contains scripts to easily start and stop a PostgreSQL database using Docker.

## Prerequisites

- [Docker](https://www.docker.com/products/docker-desktop/)
- [Docker Compose](https://docs.docker.com/compose/install/) (included in Docker Desktop)

## Default Configuration

- **PostgreSQL Version**: 16 (latest stable)
- **Port**: 5432
- **Username**: postgres
- **Password**: postgres
- **Database**: mydb
- **Data Volume**: postgres_data (persisted between restarts)

## Getting Started

Make the scripts executable:

```bash
chmod +x start-postgres.sh stop-postgres.sh status-postgres.sh
```

### Starting PostgreSQL

```bash
./start-postgres.sh
```

This script will:
1. Start a PostgreSQL container
2. Wait for it to be ready
3. Display connection information

### Checking Status

```bash
./status-postgres.sh
```

This script will show if PostgreSQL is running and display connection details.

### Stopping PostgreSQL

```bash
./stop-postgres.sh
```

This script stops the PostgreSQL container while preserving your data.

## Connection Information

Once the database is running, you can connect to it using:

- **Host**: localhost
- **Port**: 5432
- **Username**: postgres
- **Password**: postgres
- **Database**: mydb

### Connect with psql client:

```bash
psql -h localhost -U postgres -d mydb
```

### Connect from applications:

Connection string format:
```
postgresql://postgres:postgres@localhost:5432/mydb
```

## Customizing the Setup

You can modify the `docker-compose.yml` file to change:

- Database name, username, and password
- Port mappings
- Volume configuration
- Add initialization scripts

## Data Persistence

The database data is stored in a Docker volume named `postgres_data` which persists between container restarts. To completely reset the data, you would need to remove this volume:

```bash
docker volume rm db_postgres_data
```

## Troubleshooting

If you encounter issues, check the container logs:

```bash
docker-compose logs postgres
```
