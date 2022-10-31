# Note App
Note App that handles the CRUD operations and database to persist your data, 
a server that will handle requests, RESTful API endpoints, a static HTML, CSS, 
JavaScript Frontend with simple login and registration functionality, and the ability to add, 
update and delete notes that are specific to the user who is currently logged in. 

### Built
* Java
* JavaScript
* Spring
* Maven
## Getting Started
### Prerequisities
Heroku was used to host database

### Installation 
1. Clone repo
```
https://github.com/edgarefigueroa/java-proj-4.git
```
2. 
* The application.properties file is where all the configuration takes place for configuring a Spring Boot Application. We need to set a few properties here to connect to our external datasource, be sure to replace the Heroku Credentials with the actual credentials for your heroku project:

    * spring.datasource.url=jdbc:postgresql://HEROKU_CREDENTIAL_HOST:5432/HEROKU_DB

    * spring.datasource.username=HEROKU_CREDENTIAL_USERNAME

    * spring.datasource.password=HEROKU_CREDENTIAL_PASSWORD

    * spring.datasource.driverClassName=org.postgresql.Driver

    * spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL95Dialect

    * spring.jpa.hibernate.ddl-auto=[validate, update, create-drop, create]

    * Choose one from the previous options, until you have your schema set, `create-drop` is the most helpful. After you get your schema to where you want, change this property to `create` and start the application. The once it is running change the property to `update` while you finish development

    * And these two are optional but helpful for development:
    
      * logging.level.sql=debug

      * spring.jpa.show-sql=true
      
CAUTION: IF YOU PUSH THIS TO GITHUB, YOUR CREDENTIALS WILL BE AVAILABLE PUBLICLY AND ANYONE WOULD BE ABLE TO ACCESS THIS DATABASE. BE SURE TO ADD THE application.properties FILE TO THE .gitignore SO THAT YOU DO NOT LEAK YOUR CREDENTIALS.

Run project then visit http://localhost:8080/register

## Project Usage
- Register and Login 
- Make/Edit/Delete notes
