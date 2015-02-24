# Author Damodar R Yemme (dyemme{at}gmail.com) for any help with setup or issues.
# NGC
Example to create SOAP Web Services and RESTFul services using Postgre SQL deploying on Tomcat or Liberty profile server.
Student client project uses soapClient.js to interact with SOAP Service and RESTFul service.
Required Tools#
Eclipse Luna 
Postgres database
IBM Liberty profile server.

#Database scripts for "Student" database

CREATE TABLE STUDENT
(
  STUDENT_ID serial NOT NULL,
  FIRST_NAME character varying(50),
  LAST_NAME character varying(50),
  MIDDLE_NAME character varying(50),
  CONSTRAINT PF_STUDENT PRIMARY KEY (STUDENT_ID)
);

Insert into student (first_name,last_name,middle_name) values ('John','Doe','');

Insert into student (first_name,last_name,middle_name)values('John2','Doe2','II');

Insert into student (first_name,last_name,middle_name)values('John3','Doe3','III');

Insert into student (first_name,last_name,middle_name)values('John4','Doe4','IV');

update student set first_name='John2',last_name='Doe2' where student_id=1002;

select *from student;
