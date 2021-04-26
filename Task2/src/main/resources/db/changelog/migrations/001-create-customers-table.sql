create table customers
(
    id serial primary key,
    name varchar(255) not null,
    surname varchar(255) not null,
    age int check (age >= 0) not null,
    phone_number varchar(255) not null
);