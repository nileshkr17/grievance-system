How to Run PostgreSQL in Docker:
Start PostgreSQL with Docker Compose:

The docker-compose.yml file I provided earlier already has the PostgreSQL setup. It uses the postgres:15 Docker image, which will run a PostgreSQL container with persistent data storage.

To start PostgreSQL, run:

bash
Copy
Edit
docker-compose up postgres
This will start the PostgreSQL container and bind the database to localhost:5432.

Start the Entire System (Including Spring Boot):

After PostgreSQL is running, to bring up the full application (including the backend Spring Boot app), run:

bash
Copy
Edit
docker-compose up --build
Verify PostgreSQL is Running:

PostgreSQL should now be accessible at localhost:5432. Each developer can use the credentials defined in the docker-compose.yml file:

Database: grievance_db

Username: postgres

Password: postgres

Developers can access the DB directly using any PostgreSQL GUI tool (e.g., pgAdmin, DBeaver), or by using the psql CLI.

PostgreSQL Persistence:

The docker-compose.yml uses a volume (pgdata) to persist data across container restarts. So, even if Docker is restarted, the PostgreSQL data will persist.


App will be available at http://localhost:8080


NILESH IR

