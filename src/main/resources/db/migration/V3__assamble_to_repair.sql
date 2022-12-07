create table if not exists repair_order
(
    id int not null ,
    first_name varchar(255),
    last_name varchar(255),
    car_production_date date,
    make_of_car varchar(255),
    model varchar(255),
    is_car_premium boolean,
    ownerId int,
    primary key (id),
    foreign key (ownerId) references owner(ownerId)
);

create table if not exists car_parts_to_repair
(
  id int not null ,
  part_name varchar(255),
  number_of_parts varchar(255),
  summary_price varchar(255),
  repair_order_id int,
  primary key (id),
  foreign key (repair_order_id) references repair_order(id)
);