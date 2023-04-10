 create table if not exists owner
 (
     id bigint not null unique ,
     first_name varchar(255),
     last_name varchar(255),
     age int not null ,
     identity varchar(255),
     street_name varchar(255),
     postal_code int not null ,
     city varchar(255),
     available_amount_of_money double precision,
     primary key (id)
 );

 create table if not exists car
 (
     id bigint not null unique ,
     type_of_engine varchar(255),
     model varchar(255),
     make_of_car varchar(255),
     owner_id bigint,
     primary key (id),
     foreign key (owner_id) references owner(id)
 );
create table if not exists car_parts
(
    id bigint not null unique ,
    wheel varchar(255),
    brakes varchar(255),
    alu_rim varchar(255),
    turbine varchar(255),
    lights varchar(255),
    light_bulb varchar(255),
    gearbox varchar(255),
    wipers varchar(255),
    oil_sump varchar(255),
    exhaust varchar(255),
    engine varchar(255),
    car_id bigint,
    primary key (id),
    foreign key (car_id) references car(id)
);

create table if not exists car_service
(
    id bigint not null unique,
    min_price_for_wheel float,
    min_price_for_brakes float,
    min_price_for_turbine float,
    min_price_for_alu_rim float,
    min_price_for_exhaust float,
    min_price_for_oil_sump float,
    min_price_for_wipers float,
    min_price_for_light_bulb float,
    min_price_for_lights float,
    min_price_for_gearbox float,
    min_price_for_engine float,
    max_price_for_wheel float,
    max_price_for_brakes float,
    max_price_for_turbine float,
    max_price_for_alu_rim float,
    max_price_for_exhaust float,
    max_price_for_oil_sump float,
    max_price_for_wipers float,
    max_price_for_light_bulb float,
    max_price_for_lights float,
    max_price_for_gearbox float,
    max_price_for_engine float,
    owner_id bigint,
    primary key(id),
    foreign key(owner_id) references owner(id)
);
