SQL> create or replace procedure empcount
  2  (
  3  deptno in employees.department_id%Type,
  4  totalcount out number
  5  )
  6  as
  7  begin
  8  select count(*) into totalcount  from employees where department_id = deptno;
  9  end;
 10  /

Procedure created.

SQL>