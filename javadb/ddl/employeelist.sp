SQL>  create or replace procedure employeelist
  2  (
  3   p_deptno in employees.department_id%Type,
  4  p_recordset out SYS_REFCURSOR
  5  )
  6  as
  7  begin
  8  open p_recordset for
  9  select employee_id, first_name || last_name as emp_name, email , salary fro
m employees where department_id = p_deptno order by employee_id;
 10  end;
 11  /

Procedure created.

SQL>