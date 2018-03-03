Different types of result set options can be given to handle data coming out of Database.

ResultSet Types - 
-----------------------------
Type_Forward_Only (default) - as the name says only forward movement
Type_Scroll_Insensitive - forward and backward . does not care about updates by others.
Type_Scroll_Sensitive - forward and backward . cares about updates by others.

ResultSet Concurrency Types -
----------------------------- 
Concur_Read_Only - default 
Concur_Updatable - can update data in tables


Different types of statement interfaces are used to execute SQL against DB.
3 key types are - Statement, PreparedStatement

Statement Interface
---------------------
. Used for executing static SQL Statement
	. ResultSet executeQuery(String SQL)
	. int executeUpdate(String SQL) - for DDL also. Return - number of rows affected.
	. boolean execute(String SQL) - more than one Result set or update count.

PreparedStatement Interface extends Statement
-----------------------------
. Used for SQL statements that have parameters
executeQuery is used for getting results. It returns ResultSet type.
executeUpdate is used for Insert, Update and Delete. Returns int. rc=1 means SUCCESS.

CallableStatement Interface extends PreparedStatement
-----------------------------
. Used for Stored Procedures.
	MySQL - use Stored Procedure Language
	Oracle - PL/SQL i.e. Procedural language extensions to the Structured Query Language
	Microsoft SQL Server - TSQL - Transact SQL
	
. Input/Output/Input Output params

execute method is used to call the SP.

BATCH Processing:
------------------
All statements mentioned above, support Batch.
addBatch(); returns void
executeBatch(); returns array of integer. identifies the update counts.

INPUT/OUTPUT Parameter
-----------------------
cstmt.setInt(1, 50); // for input param
cstmt.registerOutParameter(2, Types.INTEGER); // register output param
cstmt.execute(); // use execute statement
int totalcount=cstmt.getInt(2); // note how to get the output parameter value

CallableStatement With ResultSets
------------------------------------
you have to register OracleTypes.CURSOR as output parameter. 
in the proc declare a cursor for result set.
Iterate in java program.
Check code in DBCallableStatementResultSet