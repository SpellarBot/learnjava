*Value Type vs Entity*

_Value Type_ - something that is only used in reference to entity. Example - hand is part of person. On its own, hand is not significance or existence.

_Entity_ - exists on its own. Example - person.

**Types of relationships**

Extension of data:

Example - adding Hiring Data to employee.
* There is no seperate hibernate file.
* Class is added as component in hibernate config.
* There is no seperate table either.

Value Type:

* Look at Employee and EmployeeHistory.
* In Employee.hbm.xml, EmployeeHistory is added as idbag.
* No seperate xml is created
* Seperate table

Entity Type:

* Look at EmployeeResponsibilites
* Seperate table
* Seperate hibernate file
* Treated as another entity with one to many relationship
* EmployeeProject has Employee class , not employeeId
