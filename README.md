<html>
  <body>
    <b>A Maven project with simple Spring based web application with a controller exposing the following 4 APIs -</b>

    <li> GET /user/list</li>
    <li> POST /user/create</li>
    <li> PUT /user/update</li>
    <li> DELETE /user/delete</li>

    Those APIs will perform CRUD operations using a persistence framework on a User entity with the following fields:

    • id (long) / primary key
    • username (String) / unique
    • password
    • status / possible values: Activated/Deactivated

    The DB - MySQL is used to maintain the users record

    These 4 APIs are secured with Spring Security using inmemory BASIC authentication.

    This project includes unit tests for controllers, services and DAO classes.
  <body>
</html>
