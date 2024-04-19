drop table if exists students

Go

create table students (
	id int identity(1,1) not null,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	email varchar(50) not null,

	constraint pk_student_id_01 primary key (id)
)

Go

insert into students (first_name, last_name, email)
values
('John', 'Wick', 'john123@gmail.com'),
('Mary', 'Jane', 'mary123@yahoo.com'),
('Barry', 'Alan', 'barry123@gmail.com'),
('Jack', 'Sparrow', 'jack123@yahoo.com')

select * from students

