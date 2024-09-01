# Use the official MySQL 8.0 image as a base image
FROM mysql:8.0

# Copy custom MySQL configuration file (optional)
# COPY my-custom.cnf /etc/mysql/conf.d/

# Expose the MySQL port
EXPOSE 3306

# Run a custom SQL script on container startup (optional)
# COPY init.sql /docker-entrypoint-initdb.d/

# Default command
CMD ["mysqld"]
