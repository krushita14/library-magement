The Library Management System is a RESTful API built using Spring Boot that facilitates the management of books in a library. It allows users to perform CRUD operations (Create, Read, Update, Delete) on book records while ensuring data validation, security, and adherence to best practices.
- Prerequisites for running project
  - Java 17
  - Maven (for build and dependency management)
  - MongoDB (for database storage)
  - Git (for cloning the repository)

- URL for database connection is provided in application.properties file.

- Clone Repository using below link
  https://github.com/krushita14/library-magement.git

Endpoint

- GET	/books	Retrieve all books
- GET	books/search	Retrieve a specific book from title
- POST	/books	Add a new book
- PUT	/books/{id}	Update an existing book
- DELETE	/books/{id}	Delete a book

Access URL for Postman:
http://localhost:8080/api/books
- Use basic Authentication to test endpoint
  - Username: testuser
  - Password: testpassword 
