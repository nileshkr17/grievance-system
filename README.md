<<<<<<< HEAD
Step 3: Running PostgreSQL with Docker (for local development)
To ensure PostgreSQL works smoothly in Docker, follow these steps:

PostgreSQL in Docker:

The PostgreSQL service is already set up in the docker-compose.yml file.

If the docker-compose.yml file has been set up as previously shared, all developers do NOT need to manually run Docker for PostgreSQL. They can simply start all containers (PostgreSQL + Spring Boot) by running:

bash
Copy
Edit
docker-compose up --build
This will start both the PostgreSQL container and Spring Boot container in one go.

Important: Once the containers are up, PostgreSQL will be accessible at localhost:5432.

Persisting Data:

The docker-compose.yml includes a volume (pgdata) to persist PostgreSQL data, ensuring the database does not reset between reboots.

Developers Setup:

Developers DO NOT need to manually run PostgreSQL in isolation. The docker-compose.yml takes care of setting up PostgreSQL as part of the full system.

Developers should focus on their features (working on their respective branches) and not worry about Dockerizing PostgreSQL separately.

Step 4: Workflow for Developers (How to Work with Git)
1. Clone the Repository and Checkout Branch:
Each developer should clone the repository and switch to their respective feature branch.

For example:

Gourav (Login & Registration):

bash
Copy
Edit
git clone https://github.com/<your-username>/grievance-system.git
cd grievance-system
git checkout feature/login-registration
Similarly for the others.

2. Regular Workflow:
Each developer should follow this general workflow while developing their feature:

Pull the latest changes from the remote:

bash
Copy
Edit
git pull origin main
Make changes in the code as per their tasks.

Stage and commit the changes:

bash
Copy
Edit
git add .
git commit -m "Implemented login and registration"
Push their changes to their respective feature branch:

bash
Copy
Edit
git push origin feature/login-registration
Step 5: Pull Requests (PR) and Code Reviews
Once a developer completes their feature, they can submit a Pull Request (PR) to the main branch:

Go to GitHub.

Select your repository.

Click on New Pull Request.

Compare the feature branch with main.

Click on Create Pull Request and add reviewers.

The team can then review, comment, and approve the code before merging it into the main branch.

=======
# Grievance System (Spring Boot + PostgreSQL)

## Prerequisites
- Docker & Docker Compose
- Java 17+
- Maven

## Getting Started

1. Build the project:
   mvn clean package

2. Run Docker Compose:
   docker-compose up --build

App will be available at http://localhost:8080
>>>>>>> ebc4099 (first commit)
