SQL> create or replace procedure inoutparam
  2  (
  3  param1 in out number
  4  )
  5  as
  6  begin
  7  param1:=param1*11;
  8  end;
  9  /

Procedure created.