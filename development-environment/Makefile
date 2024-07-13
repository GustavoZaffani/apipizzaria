MIGRATION_USERNAME=pizzeria_user
MIGRATION_PASSWORD=pizzeria_user123
DATABASE_URL=jdbc:postgresql://localhost:5437/pizzeria

# Run migration for development environment
migration:
	 mvn flyway:migrate -Dflyway.user=$(MIGRATION_USERNAME) -Dflyway.url=$(DATABASE_URL) -Dflyway.password=$(MIGRATION_PASSWORD) -f ../pom.xml

# execute build without tests and run the application with development profile
run:
	mvn spring-boot:run -Dspring-boot.run.profiles=development -f ../pom.xml

# create the containers for development environment
compose-up:
	docker-compose -p pizzeria_environment up -d

# remove the containers
compose-down:
	docker-compose -p pizzeria_environment down

# Start the application locally and environment
start: compose-down compose-up migration run
