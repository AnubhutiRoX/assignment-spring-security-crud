<html>
  <body>
    A Maven project with simple Spring based web application with a controller exposing the following 4 APIs -

    • GET /user/list
    • POST /user/create
    • PUT /user/update
    • DELETE /user/delete

    Those APIs will perform CRUD operations using a persistence framework on a User entity with the following fields:

    • id (long) / primary key
    • username (String) / unique
    • password
    • status / possible values: Activated/Deactivated

    The DB - MySQL is used to maintain the users record

    These 4 APIs are secured with Spring Security using inmemory <b>BASIC authentication</b>.

    This project includes unit tests for controllers, services and DAO classes.
  <body>
</html>
