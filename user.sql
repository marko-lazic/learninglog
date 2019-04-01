alter session set "_ORACLE_SCRIPT"=true;  

create user learninglog identified by learninglog;

grant connect to learninglog;
grant create sequence to learninglog;
grant create session to learninglog;
grant create table to learninglog;
grant create trigger to learninglog;
grant unlimited tablespace to learninglog;
