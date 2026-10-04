

USE college;

CREATE TABLE student (
    student_id INT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50),
    marks INT
);

INSERT INTO student VALUES
(101, 'Sambhav', 'Java', 85),
(102, 'Rahul', 'Python', 90),
(103, 'Aman', 'DBMS', 78);