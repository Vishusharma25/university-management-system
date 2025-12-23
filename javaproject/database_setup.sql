CREATE DATABASE universitymanagementsystem;

USE universitymanagementsystem;

CREATE TABLE login (
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO login VALUES('admin', '12345');

CREATE TABLE student (
    name VARCHAR(50),
    fname VARCHAR(50),
    rollno VARCHAR(20),
    dob VARCHAR(30),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50),
    class_x VARCHAR(10),
    class_xii VARCHAR(10),
    aadhar VARCHAR(20),
    course VARCHAR(30),
    branch VARCHAR(30)
);

CREATE TABLE teacher (
    name VARCHAR(50),
    fname VARCHAR(50),
    empId VARCHAR(20),
    dob VARCHAR(30),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50),
    class_x VARCHAR(10),
    class_xii VARCHAR(10),
    aadhar VARCHAR(20),
    education VARCHAR(30),
    department VARCHAR(30)
);

CREATE TABLE subject (
    rollno VARCHAR(20),
    semester VARCHAR(20),
    subject1 VARCHAR(50),
    subject2 VARCHAR(50),
    subject3 VARCHAR(50),
    subject4 VARCHAR(50),
    subject5 VARCHAR(50)
);

CREATE TABLE marks (
    rollno VARCHAR(20),
    semester VARCHAR(20),
    marks1 VARCHAR(20),
    marks2 VARCHAR(20),
    marks3 VARCHAR(20),
    marks4 VARCHAR(20),
    marks5 VARCHAR(20)
);

CREATE TABLE fee (
    course VARCHAR(30),
    semester1 VARCHAR(20),
    semester2 VARCHAR(20),
    semester3 VARCHAR(20),
    semester4 VARCHAR(20),
    semester5 VARCHAR(20),
    semester6 VARCHAR(20),
    semester7 VARCHAR(20),
    semester8 VARCHAR(20)
);

INSERT INTO fee VALUES('BTech', '50000', '45000', '48000', '47000', '50000', '45000', '48000', '47000');
INSERT INTO fee VALUES('BBA', '30000', '25000', '32000', '28000', '30000', '25000', '32000', '28000');
INSERT INTO fee VALUES('BCA', '40000', '35000', '38000', '37000', '40000', '35000', '38000', '37000');
INSERT INTO fee VALUES('Bsc', '25000', '20000', '22000', '24000', '25000', '20000', '22000', '24000');
INSERT INTO fee VALUES('Msc', '35000', '30000', '32000', '34000', '35000', '30000', '32000', '34000');
INSERT INTO fee VALUES('MBA', '60000', '55000', '58000', '57000', '0', '0', '0', '0');
INSERT INTO fee VALUES('MCA', '50000', '45000', '48000', '47000', '0', '0', '0', '0');

CREATE TABLE collegefee (
    rollno VARCHAR(20),
    course VARCHAR(30),
    branch VARCHAR(30),
    semester VARCHAR(30),
    fee_paid VARCHAR(30)
);

CREATE TABLE studentleave (
    rollno VARCHAR(20),
    date VARCHAR(50),
    duration VARCHAR(20)
);

CREATE TABLE teacherleave (
    empId VARCHAR(20),
    date VARCHAR(50),
    duration VARCHAR(20)
);
