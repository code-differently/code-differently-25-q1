FROM postgres:16-alpine

# Create a directory for initialization scripts
RUN mkdir -p /docker-entrypoint-initdb.d

# Add any initialization scripts if needed
# COPY ./init-scripts/ /docker-entrypoint-initdb.d/

# Set environment defaults (these can be overridden in docker-compose.yml)
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=mydb

# Expose the PostgreSQL port
EXPOSE 5432

# Set the data directory
VOLUME ["/var/lib/postgresql/data"]

# Set health check command
HEALTHCHECK --interval=5s --timeout=5s --retries=5 \
  CMD pg_isready -U postgres || exit 1
