-- create table owner
-- (
--     id bigint not null ,
--     firstName varchar(255),
--     lastName varchar(255),
--     age int not null ,
--     identity varchar(255),
--     streetName varchar(255),
--     postalCode int not null ,
--     city varchar(255),
--     availableAmountOfMoney double precision
-- );
--
-- create table car
-- (
--     id bigint not null,
--     typeOfEngine varchar(255),
--     model varchar(255),
--     makeOfCar varchar(255),
--     ownerId int,
--     primary key (id),
--     foreign key (ownerId) references owner(id)
-- );