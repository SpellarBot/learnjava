Refer to 
There are 2 things to understand:
Drivers - used to connect to specific DB
DriverManager - used to find out which driver to use.

Class.forName() used to be required for load the Drivers. Not from JDBC 4.0 onwards.
getConnection() method is called - DriverManager will locate suitable Driver

JDBC Driver is a set of Java classes that implement JDBC Interfaces, targeting a specific DB

4 types of drivers:

1. JDBC-ODBC Bridge
2. Native API driver
3. Network-Protocol driver ( middleware driver )
4. Database-Protocol driver (Pure Java driver )


1. JDBC-ODBC Bridge
Uses ODBC Driver to connect to the database.
Converts JDBC method calls to Native ODBC drivers for specific DBs.
ODBC Drivers for specific DBs will convert the ODBC calls to Native Database Calls using vendor provided libraries, which are sent to DB for processing.

2. Native API driver
Native API driver converts JDBC Method calls converts to Native API calls of DB using client side libs of database.
Not all DBs have client side libs 
Not thread safe

3. Network-Protocol driver ( middleware driver )
JDBC calls converted to DB independent Middleware calls
Middleware software would convert these to db specific calls.
slow due to network calls.

4. Database-Protocol driver (Pure Java driver )
JDBC calls passed to Native protocol driver, which converts to vendor specific DB calls.
vendor supplies client side libs.
NO ODBC, or middleware.
All code in Java so platform independent.

USAGE:
Type 4 - if accessing one type of DB like Oracle, SQL server.
Type 3 - when accessing multiple types of DB at same time.
Type 2 - when type 3 or 4 is not available.
Type 1 - not used in production env.  