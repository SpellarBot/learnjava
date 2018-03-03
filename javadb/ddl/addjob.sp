statement for creating SP in Oracle DB.

SQL> create or replace procedure addjob (
  2  jobid jobs.JOB_ID%TYPE,
  3  jobtitle jobs.JOB_TITLE%TYPE,
  4  minsal jobs.MIN_SALARY%TYPE,
  5  maxsal jobs.MAX_SALARY%TYPE
  6  )
  7  is
  8  begin
  9  insert into jobs values ( jobid, jobtitle, minsal, maxsal );
 10  commit;
 11  end;
 12  /

Procedure created.

SQL>