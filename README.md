# Floor Management Service

A Spring Boot microservice for managing mall floors, stores, and related operations.

## Project Structure

- `src/main/java/com/mallmanagement/floor/` – Main application and business logic
- `src/main/resources/` – Application configuration and static assets
- `src/test/java/com/mallmanagement/floor/` – Unit and integration tests

## Prerequisites

- Java 17 (or the version defined in `pom.xml`)
- Maven 3.8+
- Git

## Build and Run

From the project root (`floor-management-service`):

```cmd
mvn clean install
mvn spring-boot:run
```

The application will start on the port configured in `src/main/resources/application.properties` (typically `http://localhost:8080`).

## Testing

```cmd
mvn test
```

## Git Workflow

Basic workflow used for this project:

1. Make code or documentation changes.
2. Check status:
   ```cmd
   git status
   ```
3. Stage changes:
   ```cmd
   git add README.md
   ```
4. Commit:
   ```cmd
   git commit -m "Update README with project details"
   ```
5. Push to GitHub:
   ```cmd
   git push origin main
   ```

## Notes

- This README was last updated on 2025-12-15.
- Adjust commands as needed if you use a different branch name or Java/Maven version.
