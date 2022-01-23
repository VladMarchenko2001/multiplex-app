# Cinema app

This application was created to simulate simple multiplex cinema ticket flow.

It's written with high-level technologies such as Hibernate and Spring and is based on SOLID and REST architectural principles.

### Implementation details
*Multiple endpoints with different access rights*

#### Endpoints before authentication:
* POST: /register - register new user
* POST: /login - login user

#### Endpoints after authentication:
For ADMIN role only:
* GET /users/by-email - find user by email
* POST /cinema-halls - add new cinema hall
* POST /movies - add new movie
* POST movie-sessions - add new movie session
* PUT /movie-sessions/{id} - update a movie session by id
* DELETE /movie-sessions/{id} - delete a movie session by id

For both USER and ADMIN roles:
* GET /cinema-halls - get all cinema halls
* GET /movies - get all movies
* GET /movie-sessions/available - get movie sessions on selected date

For USER role only:
* GET /shopping-carts/by-user - get shopping cart
* GET /orders - get order history
* POST /orders/complete - move tickets from cart to new order
* PUT shopping-carts/movie-sessions - add movie session to shopping cart

All data is stored in the MySQL database.

### Technologies used
* Java
* Apache Tomcat
* Hibernate
* MySQL
* Spring: Spring Core, Spring Web, Spring Security
* Postman API tool

### Useful tips
* Initially you will have user ```user@gmail.com``` will be created during tests
* Simple restart application after tests to remove test data.
* Check ```src/main/java/multiplex/config/DataInitializer.java```. You can redact it if you need
* Check Postman collection requests bodies and URLs. You will see JSON formats needed here

### Good Luck
Enjoy and good luck! :)