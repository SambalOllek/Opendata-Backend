# Opendata-Backend

##Getting Started
1. You need to set up a server to run this application on.
2. A server for hosting the database is also needed (XAMPP for example)
3. Import the .sql file located in this directory to your database server.
5. Download declared dependencies when first running this project
6. Declared dependencies can be found in `pom.xml`
7. When first running the fullstack project it is recommended to run the following GET request: http://localhost:8080/api/scrape.
This is needed to populate the database with car items from https://bytbil.com.

####To use this api in frontend, the following usable paths are listed here
 - GET
    - http://localhost:8080/api/cars
    Gets car items from database and forwards said items as JSON
 
 - POST
 
 - DELETE