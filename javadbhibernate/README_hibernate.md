*Value Type vs Entity*

_Value Type_ - something that is only used in reference to entity. Example - hand is part of person. On its own, hand is not significance or existence.

_Entity_ - exists on its own. Example - person.

**Types of relationships**

Extension of data:

Example - adding Hiring Data to employee.
* There is no separate hibernate file.
* Class is added as component in hibernate config.
* There is no separate table either.

Value Type:

* Look at Employee and EmployeeHistory.
* In Employee.hbm.xml, EmployeeHistory is added as idbag.
* No separate xml is created
* Separate table

Entity Type:

* Look at EmployeeResponsibilites
* Separate table
* Separate hibernate file
* Treated as another entity with one to many relationship
* EmployeeProject has Employee class , not employeeId

**PROJECT CODE**
|*Name*|*Type*|
|Employee|Main class for example. An Entity|
|HiringData|Composite key. No separate hbm file.|
|EmployeeHistory|Dependent Entity.No separate hbm file.|
|EmployeeProject|Separate Entity. Separate hbm file. One to Many relationship|
|EmployeeMnpi|Separate Entity. Separate hbm file. One to One relationship|

By default hibernate configuration looks for hibernate.cfg.xml in home directory.

