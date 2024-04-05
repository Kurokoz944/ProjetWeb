create table students
(
    id SERIAL PRIMARY KEY,
    first_name TEXT not null,
    last_name TEXT not null,
    birthdate date null,
    major_id int null,
    image bytea null
);

create table majors
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    description TEXT not null
);

create table courses
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    hours int not null
);

create table student_course
(
    id SERIAL PRIMARY KEY,
    student_id int not null,
    course_id int not null
);

ALTER SEQUENCE students_id_seq RESTART 10000 INCREMENT BY 50;
ALTER SEQUENCE majors_id_seq RESTART 10000 INCREMENT BY 50;
ALTER SEQUENCE courses_id_seq RESTART 10000 INCREMENT BY 50;
ALTER SEQUENCE student_course_id_seq RESTART 10000 INCREMENT BY 50;

