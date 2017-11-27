# Mig-gres
# A drop-in PostgreSql schema migrator for a containerized world

The goal of this project is to build a tiny drop-in Java service that will be able to update a Postgresql schema. 

## Development

The project uses maven to handle dependencies and is currently running in Java 8.

Run `mvn clean install` and run against a Java web container.

There is an included Dockerfile which can be used to create images with Alpine Linux, Java 8 and Jetty 9.4. 

## Progress

### Completed

### Planned

  - Persisting settings to a location
  - Add database connection
  - Add table (support for text, number, date, timestamp types and PKs)
  - Adding columns
  - Removing colums
  - Adding Indexes

### Long-term plans

  - Front-end in Angular
  - Copy schema (From one DB to another)

### Stack

  - **Java 8**
  - **Jetty**
  - **Apline Linux**






